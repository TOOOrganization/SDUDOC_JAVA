package cn.edu.sdu.sdudoc.sdudocmbg.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ums_user")
public class UmsUserController {
    @Autowired
    private UmsUserRepository repository;

    @RequestMapping("/find_all")
    @ResponseBody
    List<UmsUser> findAll() {
        return repository.findAll();
    }

    @RequestMapping("/count")
    @ResponseBody
    long count() { return repository.count();}

    @RequestMapping("/save")
    @ResponseBody
    UmsUser save(UmsUser entity){
        return repository.save(entity);
    }

    @RequestMapping("/save_all")
    @ResponseBody
    List<UmsUser> saveAll(List<UmsUser> list){
        return repository.saveAll(list);
    }

    @RequestMapping("/delete")
    @ResponseBody
    void delete(String uid){
        repository.deleteById(uid);
    }

    @RequestMapping("/find_by_id")
    @ResponseBody
    Optional<UmsUser> findById(String uid){
        return repository.findById(uid);
    }

    @RequestMapping("/find_by_username")
    @ResponseBody
    List<UmsUser> findByUsername(String username){
        return repository.findByUsername(username);
    }

    @RequestMapping("/find_by_email")
    @ResponseBody
    List<UmsUser> findByEmail(String email){
        return repository.findByEmail(email);
    }

    @RequestMapping("/find_by_phone")
    @ResponseBody
    List<UmsUser> findByPhone(String phone){
        return repository.findByPhone(phone);
    }

    @RequestMapping("/find_by_logintime")
    @ResponseBody
    List<UmsUser> findByLoginTime(Date loginTime){
        return repository.findByLoginTime(loginTime);
    }
}
