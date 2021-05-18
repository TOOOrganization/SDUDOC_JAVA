package cn.edu.sdu.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface DocService {

    String insertSdudoc(JSONObject json) throws SolrServerException, IOException;
}
