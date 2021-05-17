package cn.edu.sdu.sdudoc.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

public interface SolrService {
    SolrDocumentList query(String corename, String defaultfield, String query, String sort,
                           Integer start, Integer rows, String... filterqueries) throws SolrServerException, IOException;

    String insertSdudoc(JSONObject json) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException;
}
