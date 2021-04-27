package cn.edu.sdu.sdudoc.util;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.serviceImpl.DmsArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoInput {

    @Autowired
    private DmsArticleService dmsArticleService;

    public void saveArticle(DmsArticle dmsArticle){ dmsArticleService.save(dmsArticle);}
}
