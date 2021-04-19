package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Img;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<Img> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    Img save(Img entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<Img> saveAll(List<Img> list){
        return repository.saveAll(list);
    }

    @RequestMapping("/delete")
    @ResponseBody
    void delete(Long id){
        repository.deleteById(id);
    }

    @RequestMapping("/find_by_id")
    @ResponseBody
    Optional<Img> findById(Long id){
        return repository.findById(id);
    }

}
