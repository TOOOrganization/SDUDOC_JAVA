package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.service.Ds2AuthorityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ds2_authority")
public class Ds2AuthorityManagementController {

    @Autowired
    Ds2AuthorityManagementService ds2AuthorityManagementService;

    @RequestMapping(value = "/selectRoleForUser", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<JpaRoleForUserVo>> selectRoleForUser(Integer userId){
        return CommonResult.success(ds2AuthorityManagementService.selectRoleForUser(userId));
    }
}
