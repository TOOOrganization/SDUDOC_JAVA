package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.util.DataOutput;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
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

    public void addData(Object o) throws SolrServerException, IOException {
        if (o instanceof DmsArticle){
            System.out.println(o);
            solrClient.addBean("dms_article",o);
            solrClient.commit("dms_article");
            System.out.println("添加成功"+o);
        }else if(o instanceof DmsCharacter){
            System.out.println(o);
            solrClient.addBean("dms_character",o);
            solrClient.commit("dms_character");
            System.out.println("添加成功"+o);
        }
    }

    public void addDataDmsArticle() throws SolrServerException, IOException {
        List<DmsArticle> l = dataOutput.findAllDmsArticle();
        for(DmsArticle dmsArticle :l){
            System.out.println(dmsArticle);
            solrClient.addBean("dms_article",dmsArticle);
            solrClient.commit("dms_article");
            System.out.println("添加成功"+dmsArticle);
        }
    }
}
