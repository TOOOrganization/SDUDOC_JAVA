package cn.edu.sdu.search.service;

import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface CloudAuditService {
    String insertSolr(String core, Object o) throws SolrServerException, IOException;
}
