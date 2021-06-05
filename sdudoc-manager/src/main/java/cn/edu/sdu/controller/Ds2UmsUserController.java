package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.component.JpaRightForRoleVo;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.entity.ds2.UmsUser;
import cn.edu.sdu.repository.ds2.UmsRightRepository;
import cn.edu.sdu.repository.ds2.UmsRoleRepository;
import cn.edu.sdu.repository.ds2.UmsUserRepository;
import cn.edu.sdu.service.Ds2AuthorityManagementService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ds2_user")
public class Ds2UmsUserController {

    @Autowired
    private UmsUserRepository umsUserRepository;

    @Autowired
    private UmsRoleRepository umsRoleRepository;

    @Autowired
    private UmsRightRepository umsRightRepository;

    @Autowired
    Ds2AuthorityManagementService ds2AuthorityManagementService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        List<Map<String, Object>> result = new ArrayList<>();
        List<UmsUser> userList = umsUserRepository.findAll();
        for (UmsUser umsUser : userList){
            Map<String, Object> map = new HashMap<>();
            map.put("user", umsUser);
            List<JpaRoleForUserVo> roleList = ds2AuthorityManagementService.selectRoleForUser(umsUser.getUid());
            map.put("role", roleList);
            List<List<JpaRightForRoleVo>> rightList = new ArrayList<>();
            for (JpaRoleForUserVo jpaRoleForUserVo : roleList){
                rightList.add(ds2AuthorityManagementService.selectRightForRole(jpaRoleForUserVo.getRid()));
            }
            map.put("right", rightList);
            result.add(map);
        }
        System.out.println(result);

        return CommonResult.success(JSON.toJSONString(result));
    }
}
