package cn.edu.sdu.sdudoc.sdudocmanager.service;

import cn.edu.sdu.sdudoc.sdudocmanager.result.QueryResults;
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
