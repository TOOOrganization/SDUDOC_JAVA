package cn.edu.sdu;

import cn.edu.sdu.controller.SolrController;
import cn.edu.sdu.exception.HttpStatusException;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SdudocManagerApplication.class)
public class SolrTest {

    @Autowired
    SolrController solrController;

    @Test
    public void query() throws SolrServerException, IOException {
        solrController.query("dms_article", "","","",0,1,"","");
    }

    @Test
    public void delete() throws SolrServerException, IOException, HttpStatusException {
        System.out.println(solrController.delete("dms_article", "8c7ef9a0-d80c-4f5c-8445-979a3e424232"));
    }
}
