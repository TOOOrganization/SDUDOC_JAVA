package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsRoleRightRelation;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsRoleRightRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ums_role_right_relation")
public class UmsRoleRightRelationController {
    @Autowired
    private UmsRoleRightRelationRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsRoleRightRelation> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsRoleRightRelation save(UmsRoleRightRelation entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsRoleRightRelation> saveAll(List<UmsRoleRightRelation> list){
        return repository.saveAll(list);
    }

}
