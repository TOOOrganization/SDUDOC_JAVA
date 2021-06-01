package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.exception.HttpStatusException;
import cn.edu.sdu.sdudoc.result.QueryResults;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.List;

public interface SolrService {
    QueryResults query(String coreName,
                       String defaultField,
                       String query,
                       String sortField,
                       String order,
                       Integer start,
                       Integer rows,
                       String... filterQueries) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException;

    String getPNG(String pid) throws HttpStatusException;

    List<String> getPNGs(String pids) throws HttpStatusException;
}
