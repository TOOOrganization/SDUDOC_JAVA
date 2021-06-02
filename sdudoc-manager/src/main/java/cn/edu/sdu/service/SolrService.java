package cn.edu.sdu.service;

import cn.edu.sdu.exception.HttpStatusException;
import cn.edu.sdu.result.QueryResults;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.GroupCommand;

import java.io.IOException;
import java.util.List;

public interface SolrService {

    String SOLRHOST = "http://211.87.232.163:8080/solr";

    QueryResults query(String coreName,
                       String defaultField,
                       String query,
                       String sort,
                       Integer start,
                       Integer rows,
                       String fields,
                       String... filterQueries) throws SolrServerException, IOException;

    List<GroupCommand> groupQuery(String coreName,
                                  String defaultField,
                                  String query,
                                  String sort,
                                  Integer start,
                                  Integer rows,
                                  String group,
                                  String fields,
                                  String... filterQueries) throws SolrServerException, IOException;

    String delete(String coreName, String id) throws SolrServerException, IOException, HttpStatusException;

    String deleteMany(String coreName, String _id) throws SolrServerException, IOException, HttpStatusException;
}
