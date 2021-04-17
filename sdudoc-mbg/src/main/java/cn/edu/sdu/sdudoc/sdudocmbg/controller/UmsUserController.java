package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ums_user")
public class UmsUserController {
    @Autowired
    private UmsUserRepository umsUserRepository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsUser> findAll() {
        return umsUserRepository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return umsUserRepository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsUser save(UmsUser umsUser){
        return umsUserRepository.save(umsUser);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsUser> saveAll(List<UmsUser> umsUser){
        return umsUserRepository.saveAll(umsUser);
    }

//    @RequestMapping("/delete")
//    @ResponseBody
//    void delete()
}
