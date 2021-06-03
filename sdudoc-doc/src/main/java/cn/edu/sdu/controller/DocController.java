package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.service.DocService;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Autowired
    private DocService docService;

    @ResponseBody
    @RequestMapping(value = "/insert_sdudoc", method = RequestMethod.POST, produces = "application/json")
    public CommonResult<String> insertSdudoc(@RequestBody JSONObject json) throws SolrServerException, IOException {
        String insertSdudoc = docService.insertSdudoc(json);
        return CommonResult.success(insertSdudoc);
    }

}
