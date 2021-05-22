package cn.edu.sdu.service;

import cn.edu.sdu.result.QueryResults;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SolrService {

    QueryResults query(String coreName,
                       String defaultField,
                       String query,
                       String sortField,
                       String order,
                       Integer start,
                       Integer rows,
                       String... filterQueries) throws SolrServerException, IOException;
}
