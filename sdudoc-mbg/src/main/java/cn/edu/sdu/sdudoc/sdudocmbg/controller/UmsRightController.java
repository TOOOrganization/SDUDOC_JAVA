package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Article;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsRight;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ums_right")
public class UmsRightController {
    @Autowired
    private UmsRightRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsRight> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsRight save(UmsRight entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsRight> saveAll(List<UmsRight> list){
        return repository.saveAll(list);
    }

}
