package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface CloudAuditService {
    String insertSolr(String core, Object o) throws SolrServerException, IOException;
}
