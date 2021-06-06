package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.api.ResultCode;
import cn.edu.sdu.component.Ds2ManagerUserDetails;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.entity.ds2.UmsUser;
import cn.edu.sdu.repository.ds2.UmsUserRepository;
import cn.edu.sdu.service.Ds2AuthorityManagementService;
import cn.edu.sdu.service.Ds2ManagerUserDetailsService;
import cn.edu.sdu.util.JwtTokenUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Ds2ManagerUserDetailsServiceImpl implements Ds2ManagerUserDetailsService {

    @Autowired
    UmsUserRepository umsUserRepository;

    @Autowired
    Ds2AuthorityManagementService ds2AuthorityManagementService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsUser umsUser = umsUserRepository.findByUsername(username).get(0);

        List<GrantedAuthority> authorityList = new ArrayList<>();
        List<JpaRoleForUserVo> jpaRoleForUserVos = ds2AuthorityManagementService.selectRoleForUser(umsUser.getUid());

        jpaRoleForUserVos.forEach( role -> {
            authorityList.add(new SimpleGrantedAuthority(role.getRole_name()));
        });
        return new Ds2ManagerUserDetails(umsUser, authorityList);
    }

    @Override
    public CommonResult<String> login(String username, String password) {
        JSONObject resultJsonObject = new JSONObject();

        List<UmsUser> userList = umsUserRepository.findByUsername(username);
        System.out.println(userList.size());

        if (userList.size() == 1) {
            UmsUser umsUser = userList.get(0);
            if (!umsUser.getPassword().equals(password)) {
                return CommonResult.failed(
                        ResultCode.PASSWORD_NOT_MATCH,
                        ResultCode.PASSWORD_NOT_MATCH.getMessage()
                );
            } else {
                umsUser.setLoginTime(new Date());
                umsUser.setCount(umsUser.getCount() + 1);

                UserDetails userDetails = loadUserByUsername(username);

                String token = jwtTokenUtil.generateToken(userDetails);

                resultJsonObject.put("token", token);
                resultJsonObject.put("user", umsUser);

                return CommonResult.success(resultJsonObject.toJSONString(), ResultCode.LOGIN_SUCCESS.getMessage());
            }
        }else{
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }
    }

    @Override
    public CommonResult<String> register(String username, String password, String nickname) {
        List<UmsUser> userList = umsUserRepository.findByUsername(username);

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

        umsUserRepository.save(user);

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

        List<UmsUser> userList = umsUserRepository.findByUsername(username);

        if (userList.size() == 0) {
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }

        UmsUser user = userList.get(0);
        user.setPassword(password);

        umsUserRepository.save(user);

        return CommonResult.success(
                password,
                ResultCode.PASSWORD_UPDATE_SUCCESS.getMessage()
        );
    }

    @Override
    public CommonResult<UmsUser> getByUsername(String username) {
        List<UmsUser> userList = umsUserRepository.findByUsername(username);

        if (userList.size() == 0) {
            return CommonResult.failed(
                    ResultCode.USER_NOT_EXIST,
                    ResultCode.USER_NOT_EXIST.getMessage()
            );
        }

        return CommonResult.success(userList.get(0));
    }

    @Override
    public CommonResult<UmsUser> getById(Integer Id) {

        Optional<UmsUser> one = umsUserRepository.findById(Id);

        return one.map(CommonResult::success).orElseGet(() -> CommonResult.failed(
                ResultCode.USER_NOT_EXIST,
                ResultCode.USER_NOT_EXIST.getMessage()
        ));
    }

    @Override
    public CommonResult<UmsUser> getToken(String username) {
        return null;
    }

    @Override
    public CommonResult<UmsUser> refreshToken(String username) {
        return null;
    }

    @Override
    public CommonResult<UmsUser> updateUserInfo(UmsUser umsUser) {
        return CommonResult.success(umsUserRepository.save(umsUser));
    }
}
