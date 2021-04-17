package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUserRoleRelation;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRoleRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ums_user_role_relation")
public class UmsUserRoleRelationController {
    @Autowired
    private UmsUserRoleRelationRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsUserRoleRelation> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsUserRoleRelation save(UmsUserRoleRelation entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsUserRoleRelation> saveAll(List<UmsUserRoleRelation> list){
        return repository.saveAll(list);
    }

}
