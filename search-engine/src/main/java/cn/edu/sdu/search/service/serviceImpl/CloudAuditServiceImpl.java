package cn.edu.sdu.search.service.serviceImpl;

import cn.edu.sdu.search.util.SolrInput;
import cn.edu.sdu.search.service.CloudAuditService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CloudAuditServiceImpl implements CloudAuditService {

    @Autowired
    SolrInput solrInput;

    @Override
    public String insertSolr(String core, Object o) throws SolrServerException, IOException {
        try {
            solrInput.addData(core, o);
        }catch (Exception e){
            e.printStackTrace();
            return o.toString() + "插入到" + core + "失败";
        }
        return o.toString() + "插入到" + core + "成功";
    }
}
