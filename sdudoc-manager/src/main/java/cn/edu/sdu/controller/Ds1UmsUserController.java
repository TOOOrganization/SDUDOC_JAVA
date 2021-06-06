package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.component.JpaRightForRoleVo;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.repository.ds1.UmsUserRepository;
import cn.edu.sdu.service.Ds1AuthorityManagementService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ds1_user")
public class Ds1UmsUserController {

    @Autowired
    private UmsUserRepository umsUserRepository;

    @Autowired
    Ds1AuthorityManagementService ds1AuthorityManagementService;

    @PreAuthorize("hasAnyRole('administrator', 'administrator_editor')")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> findAll(){
        List<Map<String, Object>> result = new ArrayList<>();
        List<UmsUser> userList = umsUserRepository.findAll();
        for (UmsUser umsUser : userList){
            Map<String, Object> map = new HashMap<>();
            map.put("user", umsUser);
            List<JpaRoleForUserVo> roleList = ds1AuthorityManagementService.selectRoleForUser(umsUser.getUid());
            map.put("role", roleList);
            List<List<JpaRightForRoleVo>> rightList = new ArrayList<>();
            for (JpaRoleForUserVo jpaRoleForUserVo : roleList){
                rightList.add(ds1AuthorityManagementService.selectRightForRole(jpaRoleForUserVo.getRid()));
            }
            map.put("right", rightList);
            result.add(map);
        }

        return CommonResult.success(JSON.toJSONString(result));
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_editor')")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> insert(@RequestBody JSONObject user){
        System.out.println(user);
        user = user.getJSONObject("user");
        String username = user.getString("username");
        String password = user.getString("password");
        String confirmPassword = user.getString("confirmPassword");
        String nickname = user.getString("nickname");
        String email = user.getString("email");
        String phone = user.getString("phone");
        Integer sex = user.getInteger("sex");
        String birthday = user.getString("birthday");
        Integer role = user.getInteger("role");
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println("confirmPassword="+confirmPassword);
        System.out.println("nickname="+nickname);
        System.out.println("email="+email);
        System.out.println("phone="+phone);
        System.out.println("sex="+sex);
        System.out.println("birthday="+birthday);
        System.out.println("role="+role);

        if (username == null || username.equals("")) {
            return CommonResult.failed("用户名不能为空");
        }

        if (password == null || password.equals("") || confirmPassword == null || confirmPassword.equals("")) {
            return CommonResult.failed("密码不能为空");
        }
        if (!password.equals(confirmPassword)) {
            return CommonResult.failed("两次输入密码不同");
        }

        if (nickname == null || nickname.equals("")) {
            return CommonResult.failed("昵称不能为空");
        }

        if (!email.equals("") && email.indexOf('@') == -1) {
            return CommonResult.failed("邮箱地址格式错误");
        }


        if (phone != null && !phone.equals("")){
            if (phone.trim().length() != 11) {
                return CommonResult.failed("号码格式不正确");
            }
            if (phone.charAt(0) != '1' || (phone.charAt(0) == '1' && "358".indexOf(phone.charAt(1)) == -1)) {
                return CommonResult.failed("号码格式不正确");
            }
        }

        if (role == null || role.equals("")) {
            return CommonResult.failed("角色不能为空");
        }

        UmsUser umsUser = new UmsUser();
        umsUser.setUsername(username);
        umsUser.setPassword(password);
        umsUser.setNickname(nickname);
        umsUser.setEmail(email);
        if (phone != null && !phone.equals("")){
            umsUser.setPhone(new BigInteger(phone));
        }
        umsUser.setSex(sex);
        umsUser.setBirthday(birthday);
        umsUser.setCount(1);
        umsUser.setStatus(1);
        umsUserRepository.save(umsUser);

        ds1AuthorityManagementService.saveUser(umsUser, role);
        return CommonResult.success("添加成功");
    }

    @PreAuthorize("hasAnyRole('administrator', 'administrator_editor')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(Integer userId){
        umsUserRepository.deleteById(userId);
    }
}
