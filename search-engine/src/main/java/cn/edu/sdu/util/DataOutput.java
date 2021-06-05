package cn.edu.sdu.util;


import cn.edu.sdu.entity.ds1.DmsArticle;

import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.service.DmsArticleService;
import cn.edu.sdu.service.DmsCharacterService;
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
