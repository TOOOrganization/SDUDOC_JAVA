package cn.edu.sdu.sdudoc.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SolrInput {
    @Autowired
    public SolrClient solrClient;

    @Autowired
    public DataOutput dataOutput;

    public void addData() throws SolrServerException, IOException {
        List<DmsArticle> l = dataOutput.findAll();
        for(DmsArticle article :l){
            System.out.println(article);
            UpdateResponse updateResponse = solrClient.addBean(article);
            solrClient.commit();
            System.out.println("添加成功"+article);
        }
    }
}
