package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.entity.ds1.UmsUserRoleRelation;
import cn.edu.sdu.service.Ds1UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ds1_user_role_relation")
public class Ds1UmsUserRoleRelationController {

    @Autowired
    Ds1UmsUserRoleRelationService ds1UmsUserRoleRelationService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> update(Integer userId, Integer roleId){
        return CommonResult.success(ds1UmsUserRoleRelationService.update(userId, roleId));
    }

}