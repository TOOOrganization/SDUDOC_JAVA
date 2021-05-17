package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsArticle;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Service
public class SolrInput {
    @Autowired
    public SolrClient solrClient;

    @Autowired
    public DataOutput dataOutput;

    public void addData(String core, Object o) throws SolrServerException, IOException {
        if (core.equals("dms_article")){
            System.out.println(o);
            solrClient.addBean("dms_article",o);
            solrClient.commit("dms_article");
            System.out.println("添加成功"+o);
        }else if(core.equals("dms_character")){
            System.out.println(o);
            solrClient.addBeans("dms_character", (Collection<?>) o);
            solrClient.commit("dms_character");
            System.out.println("添加成功"+o);
        }else if(core.equals("dms_word")){
            System.out.println(o);
            solrClient.addBeans("dms_word", (Collection<?>) o);
            solrClient.commit("dms_word");
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
