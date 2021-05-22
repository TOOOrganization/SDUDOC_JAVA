package cn.edu.sdu.sdudoc.sdudocmanager.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmanager.service.SolrService;
import cn.edu.sdu.sdudoc.sdudocmanager.component.SolrQueryBuilder;
import cn.edu.sdu.sdudoc.sdudocmanager.result.QueryResults;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SolrServiceImpl implements SolrService {

    @Autowired
    private SolrClient solrClient;

    @Override
    public QueryResults query(String coreName,
                              String defaultField,
                              String query,
                              String sortField,
                              String order,
                              Integer start,
                              Integer rows,
                              String... filterQueries) throws SolrServerException, IOException {

        SolrQueryBuilder solrQueryBuilder = new SolrQueryBuilder();
        SolrQuery solrQuery = solrQueryBuilder.setDefaultField(defaultField)
                .setQuery(query)
                .setSortField(sortField)
                .setOrder(order)
                .setStart(start)
                .setRows(rows)
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
}
