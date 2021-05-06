package cn.edu.sdu.sdudoc.sdudocmysql.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.sdudocmysql.service.DmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoInput {

    @Autowired
    private DmsArticleService dmsArticleService;

    public void saveArticle(DmsArticle dmsArticle){ dmsArticleService.save(dmsArticle);}
}
