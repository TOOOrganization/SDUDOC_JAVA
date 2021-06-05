package cn.edu.sdu.service.impl;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.api.ResultCode;
import cn.edu.sdu.component.EditorRoleForUserVo;
import cn.edu.sdu.component.EditorUserDetails;
import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.repository.ds1.UmsUserRepository;
import cn.edu.sdu.service.EditorAuthorityService;
import cn.edu.sdu.service.EditorUserDetailsService;
import cn.edu.sdu.util.JwtTokenUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EditorUserDetailsServiceImpl implements EditorUserDetailsService {

    @Autowired
    private UmsUserRepository userRepository;

    @Autowired
    private EditorAuthorityService authorityService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsUser user = userRepository.findByUsername(username).get(0);

        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<EditorRoleForUserVo> editorRoleForUserVos = authorityService.selectRoleForUser(user.getUid());

        editorRoleForUserVos.forEach( role -> {
            authorityList.add(new SimpleGrantedAuthority(role.getRole_name()));
        });

        return new EditorUserDetails(user, authorityList);
    }

    @Override
    public CommonResult<String> login(String username, String password) {

        JSONObject resultJsonObject = new JSONObject();

        List<UmsUser> userList = userRepository.findByUsername(username);

        if (userList.size() == 1) {
            UmsUser user = userList.get(0);
            if (!user.getPassword().equals(password)) {
                return CommonResult.failed(
                        ResultCode.PASSWORD_NOT_MATCH,
                        ResultCode.PASSWORD_NOT_MATCH.getMessage()
                );
            } else {
                user.setLoginTime(new Date());
                user.setCount(user.getCount() + 1);

                UserDetails userDetails = loadUserByUsername(username);

                String token = jwtTokenUtil.generateToken(userDetails);

                resultJsonObject.put("token", token);
                resultJsonObject.put("user", user);

                CommonResult.success(resultJsonObject, ResultCode.LOGIN_SUCCESS.getMessage());
            }
        }else{
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }

        return CommonResult.failed(
                ResultCode.USER_NOT_EXIST,
                ResultCode.USER_NOT_EXIST.getMessage()
        );
    }

    @Override
    public CommonResult<String> register(String username, String password, String nickname) {
        List<UmsUser> userList = userRepository.findByUsername(username);

        if (userList.size() == 1) {
            return CommonResult.failed(
                    ResultCode.USER_ALREADY_EXIST,
                    ResultCode.USER_ALREADY_EXIST.getMessage()
            );
        }

        UmsUser user = new UmsUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setStatus(1);
        user.setCount(1);

        userRepository.save(user);

        return login(username, password);
    }

    @Override
    public CommonResult<String> setPassword(String username, String password, String confirmPassword) {
        if (password == null || password.equals("") || confirmPassword == null || confirmPassword.equals("")) {
            return CommonResult.failed(
                    ResultCode.PASSWORD_IS_NULL,
                    ResultCode.PASSWORD_IS_NULL.getMessage()
            );
        }
        if (!password.equals(confirmPassword)) {
            return CommonResult.failed(
                    ResultCode.PASSWORD_IS_NOT_EQUAL,
                    ResultCode.PASSWORD_IS_NOT_EQUAL.getMessage()
            );
        }

        List<UmsUser> userList = userRepository.findByUsername(username);

        if (userList.size() == 0) {
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }

        UmsUser user = userList.get(0);
        user.setPassword(password);

        userRepository.save(user);

        return CommonResult.success(
                password,
                ResultCode.PASSWORD_UPDATE_SUCCESS.getMessage()
        );
    }

    @Override
    public CommonResult<UmsUser> getByUsername(String username) {
        List<UmsUser> userList = userRepository.findByUsername(username);

        if (userList.size() == 0) {
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }

        return CommonResult.success(userList.get(0));
    }

    @Override
    public CommonResult<UmsUser> getById(Integer id) {
        Optional<UmsUser> one = userRepository.findById(id);

        return one.map(CommonResult::success).orElseGet(() -> CommonResult.failed(
                ResultCode.USER_NOT_EXIST,
                ResultCode.USER_NOT_EXIST.getMessage()
        ));

    }

    @Override
    public CommonResult<UmsUser> updateUserInfo(UmsUser user) {
        return CommonResult.success(userRepository.save(user));
    }
}
