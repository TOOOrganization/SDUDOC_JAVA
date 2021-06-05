package cn.edu.sdu.controller;

import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.repository.ds1.DmsCharacterRepository;
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
