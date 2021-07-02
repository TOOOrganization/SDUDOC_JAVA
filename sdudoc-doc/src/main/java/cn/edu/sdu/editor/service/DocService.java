package cn.edu.sdu.editor.service;

import cn.edu.sdu.common.api.CommonResult;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface DocService {

    CommonResult<String> insertSdudoc(JSONObject json) throws SolrServerException, IOException;
}
