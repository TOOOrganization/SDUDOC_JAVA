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
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.*;

@RestController
@RequestMapping("/ds2_user")
public class Ds2UmsUserController {

    @Autowired
    private UmsUserRepository umsUserRepository;

    @Autowired
    LoginController loginController;

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

        return CommonResult.success(JSON.toJSONString(result));
    }

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

        ds2AuthorityManagementService.saveUser(umsUser, role);
        return CommonResult.success("添加成功");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(Integer userId){
        umsUserRepository.deleteById(userId);
    }


    @PostMapping("/set_password")
    public String setPassword(String username, String password, String confirmPassword) {
        if (password == null || password.equals("") || confirmPassword == null || confirmPassword.equals("")) {
            return "密码不能为空";
        }
        if (!password.equals(confirmPassword)) {
            return "两次输入密码不同";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            if (one.get().getPassword().equals(password)) {
                return "密码重复";
            } else {
                user = one.get();
                user.setPassword(password);
                umsUserRepository.save(user);
                return password;
            }
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_nickname")
    public String setNickname(String username, String nickname) {
        if (nickname == null || nickname.equals("")) {
            return "昵称不能为空";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setNickname(nickname);
            umsUserRepository.save(user);
            return nickname;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_email")
    public String setEmail(String username, String email) {
        if (email == null || email.equals("")) {
            return "邮箱不能为空";
        }
        if (email.indexOf('@') == -1) {
            return "邮箱地址格式错误";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setEmail(email);
            umsUserRepository.save(user);
            return email;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_phone")
    public String setPhone(String username, String phone) {
        if (phone == null || phone.equals("")) {
            return "手机号码不能为空";
        }
        if (phone.trim().length() != 11) {
            return "号码格式不正确";
        }
        if (phone.charAt(0) != '1' || (phone.charAt(0) == '1' && "358".indexOf(phone.charAt(1)) == -1)) {
            return "号码格式不正确";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setPhone(new BigInteger(phone));
            umsUserRepository.save(user);
            return phone;
        } else {
            return "用户不存在";
        }
    }

    @PostMapping("/set_sex")
    public Integer setSex(String username, Integer sex) {
        if (sex == null) {
            return -1;  // 参数为空
        }
        if (sex != 0 && sex != 1) {
            return -2;  // 参数不合法
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setSex(sex);
            umsUserRepository.save(user);
            return sex;
        } else {
            return -3;  // 用户不存在
        }
    }

    @PostMapping("/set_birthday")
    public String setBirthday(String username, String birthday) {
        if (birthday == null || birthday.equals("")) {
            return "生日不能为空";
        }
        if (birthday.length() != 10
                || birthday.indexOf('-') == -1
                || !birthday.substring(0, 4).matches("[0-9]*")
                || !birthday.substring(5, 7).matches("[0-9]*")
                || !birthday.substring(8).matches("[0-9]*")) {
            return "生日格式应为 yyyy-MM-dd";
        }
        UmsUser user = new UmsUser();
        user.setUsername(username);
        Optional<UmsUser> one = umsUserRepository.findOne(Example.of(user));
        if (one.isPresent()) {
            user = one.get();
            user.setBirthday(birthday);
            umsUserRepository.save(user);
            return birthday;
        } else {
            return "用户不存在";
        }
    }
}
