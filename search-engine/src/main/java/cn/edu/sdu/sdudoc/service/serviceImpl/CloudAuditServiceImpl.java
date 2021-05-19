package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import cn.edu.sdu.sdudoc.service.CloudAuditService;
import cn.edu.sdu.sdudoc.util.SolrInput;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
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
