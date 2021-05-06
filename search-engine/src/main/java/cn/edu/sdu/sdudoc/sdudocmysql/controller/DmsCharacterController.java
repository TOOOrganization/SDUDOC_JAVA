package cn.edu.sdu.sdudoc.sdudocmysql.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsCharacterRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/character")
public class DmsCharacterController {

    @Resource
    private DmsCharacterRepository dmsCharacterRepository;

    @RequestMapping("/findAll")
    @ResponseBody
    List<DmsCharacter> findAll(){ return dmsCharacterRepository.findAll();};

}
