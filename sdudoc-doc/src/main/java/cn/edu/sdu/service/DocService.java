package cn.edu.sdu.service;

import cn.edu.sdu.api.CommonResult;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface DocService {

    CommonResult<String> insertSdudoc(JSONObject json) throws SolrServerException, IOException;
}
