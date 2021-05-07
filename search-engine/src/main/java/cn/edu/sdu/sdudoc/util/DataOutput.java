package cn.edu.sdu.sdudoc.util;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;

import cn.edu.sdu.sdudoc.service.DmsArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataOutput {
    @Autowired
    private DmsArticleService dmsArticleService;

    public  List<DmsArticle> findAllDmsArticle(){
        return dmsArticleService.findAll();
    }
}
