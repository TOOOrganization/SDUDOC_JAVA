package cn.edu.sdu.sdudoc.util;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsArticle;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.service.DmsArticleService;
import cn.edu.sdu.sdudoc.service.DmsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataOutput {
    @Autowired
    private DmsArticleService dmsArticleService;

    @Autowired
    private DmsCharacterService dmsCharacterService;

    public  List<DmsArticle> findAllDmsArticle(){
        return dmsArticleService.findAll();
    }

    public Optional<DmsArticle> findArticleById(String id){return dmsArticleService.findById(id);}

    public Optional<DmsCharacter> findCharacterById(String id){return dmsCharacterService.findById(id);}
}
