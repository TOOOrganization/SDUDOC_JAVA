package cn.edu.sdu.controller;


import cn.edu.sdu.service.DocService;
import com.alibaba.fastjson.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class DocController {

    @Autowired
    private DocService docService;

    @RequestMapping(value = "/insert_sdudoc", method = RequestMethod.POST, produces = "application/json")
    public String insertSdudoc(@RequestBody JSONObject json) throws SolrServerException, IOException {
        return docService.insertSdudoc(json);
    }

}
