package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.service.SolrService;
import cn.edu.sdu.component.SolrQueryBuilder;
import cn.edu.sdu.result.QueryResults;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.sdu.util.OkHttpUtil;

import java.io.IOException;
import java.util.List;

@Service
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient solrClient;

    @Override
    public QueryResults query(String coreName,
                              String defaultField,
                              String query,
                              String sort,
                              Integer start,
                              Integer rows,
                              String fields,
                              String... filterQueries) throws SolrServerException, IOException {

        SolrQueryBuilder solrQueryBuilder = new SolrQueryBuilder();
        SolrQuery solrQuery = solrQueryBuilder.setDefaultField(defaultField)
                .setQuery(query)
                .setSort(sort)
                .setStart(start)
                .setRows(rows)
                .setFields(fields)
                .setFilterQueries(filterQueries)
                .build();

        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        SolrDocumentList results = queryResponse.getResults();
        System.out.println(results.getNumFound());

        QueryResults queryResults = new QueryResults(results.getNumFound(), results);
        System.out.println(queryResults);

        return queryResults;
    }

    @Override
    public List<GroupCommand> groupQuery(String coreName,
                                         String defaultField,
                                         String query,
                                         String sort,
                                         Integer start,
                                         Integer rows,
                                         String group,
                                         String fields,
                                         String... filterQueries) throws SolrServerException, IOException {

        SolrQueryBuilder solrQueryBuilder = new SolrQueryBuilder();
        SolrQuery solrQuery = solrQueryBuilder.setDefaultField(defaultField)
                .setQuery(query)
                .setSort(sort)
                .setStart(start)
                .setRows(rows)
                .setGroup(group)
                .setFields(fields)
                .setFilterQueries(filterQueries)
                .build();

        System.out.println(solrQuery);
        QueryResponse queryResponse = solrClient.query(coreName,solrQuery);
        GroupResponse results = queryResponse.getGroupResponse();
        System.out.println(results.getValues());

        return results.getValues();
    }

    @Override
    public String delete(String coreName, String id) throws SolrServerException, IOException, HttpStatusException {
        String url = SOLRHOST+ "/" + coreName + "/update?_=1621866163100&commitWithin=1000&overwrite=true&wt=json";
        String request = "{\"delete\":{ \"query\":\"id:"+ id +"\"}}";
        String result = OkHttpUtil.doPost(url, request, null, "POST");
        return result;
    }

    @Override
    public String deleteMany(String coreName, String _id) throws SolrServerException, IOException, HttpStatusException {
        System.out.println(_id);
        JSONArray _idArray = JSON.parseArray(_id);
        String request = "{\"delete\":{ \"query\":\"";
        for (int i=0; i<_idArray.size(); i++){
            request += "_id:"+ _idArray.get(i);
            if (i < _idArray.size()-1){
                request += " || ";
            }
        }
        request += "\"}}";

        String url = SOLRHOST+ "/" + coreName + "/update?_=1621866163100&commitWithin=1000&overwrite=true&wt=json";
        String result = OkHttpUtil.doPost(url, request, null, "POST");
        return result;
    }
}
