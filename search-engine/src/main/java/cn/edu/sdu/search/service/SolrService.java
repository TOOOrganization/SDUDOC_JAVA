package cn.edu.sdu.search.service;

import cn.edu.sdu.common.exception.HttpStatusException;
import cn.edu.sdu.search.result.QueryResults;
import org.apache.solr.client.solrj.SolrServerException;

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
                       String mode,
                       String... filterQueries) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width, String height, String mode) throws SolrServerException, IOException;

    String getPNG(String pid) throws HttpStatusException, HttpStatusException;

    List<String> getPNGs(String pids) throws HttpStatusException;
}
