package cn.edu.sdu.service;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.entity.ds2.UmsUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "ds2ManagerUserDetailsService")
public interface Ds2ManagerUserDetailsService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    CommonResult<String> login(String username, String password);

    @Transactional
    CommonResult<String> register(String username, String password, String nickname);

    @Transactional
    CommonResult<String> setPassword(String username, String password, String confirmPassword);

    CommonResult<UmsUser> getByUsername(String username);

    CommonResult<UmsUser> getById(Integer Id);

    CommonResult<UmsUser> getToken(String username);

    CommonResult<UmsUser> refreshToken(String username);

    CommonResult<UmsUser> updateUserInfo(UmsUser umsUser);

}
