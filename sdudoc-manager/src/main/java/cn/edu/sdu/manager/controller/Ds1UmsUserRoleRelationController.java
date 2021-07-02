package cn.edu.sdu.manager.controller;

import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.manager.service.Ds1UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ds1_user_role_relation")
public class Ds1UmsUserRoleRelationController {

    @Autowired
    Ds1UmsUserRoleRelationService ds1UmsUserRoleRelationService;

    @PreAuthorize("hasAnyRole('administrator', 'administrator_editor')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> update(Integer userId, Integer roleId){
        return CommonResult.success(ds1UmsUserRoleRelationService.update(userId, roleId));
    }

}