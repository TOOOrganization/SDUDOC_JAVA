package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.entity.ds2.UmsUserRoleRelation;
import cn.edu.sdu.service.Ds2UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ds2_user_role_relation")
public class Ds2UmsUserRoleRelationController {

    @Autowired
    Ds2UmsUserRoleRelationService ds2UmsUserRoleRelationService;

    @PreAuthorize("hasAnyRole('administrator', 'administrator_search')")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> update(Integer userId, Integer roleId){
        return CommonResult.success(ds2UmsUserRoleRelationService.update(userId, roleId));
    }

}
