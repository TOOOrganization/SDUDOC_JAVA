package cn.edu.sdu.sdudoc.service;

import cn.edu.sdu.sdudoc.util.PageInfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;

public interface SolrService {
//    JSONArray query(String corename,String field,String keyword) throws SolrServerException, IOException;

    SolrDocumentList query(String corename, String defaultfield, String query, String sort,
                           int start, int rows, String... filterqueries) throws SolrServerException, IOException;

    String insertSdudoc(JSONObject json) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width) throws SolrServerException, IOException;

    String getSVG(String aid, String keyword, String width, String height) throws SolrServerException, IOException;
}
