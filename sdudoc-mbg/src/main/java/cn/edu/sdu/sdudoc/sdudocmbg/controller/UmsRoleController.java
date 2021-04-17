package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsRight;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsRole;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsRightRepository;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ums_role")
public class UmsRoleController {
    @Autowired
    private UmsRoleRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsRole> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsRole save(UmsRole entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsRole> saveAll(List<UmsRole> list){
        return repository.saveAll(list);
    }

}
