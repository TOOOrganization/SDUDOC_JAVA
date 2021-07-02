package cn.edu.sdu.editor.service;

import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.entity.ds1.UmsUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface EditorUserDetailsService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    CommonResult<String> login(String username, String password);

    @Transactional
    CommonResult<String> register(String username, String password, String nickname);

    @Transactional
    CommonResult<String> setPassword(String username, String password, String confirmPassword);

    CommonResult<UmsUser> getByUsername(String username);

    CommonResult<UmsUser> getById(Integer id);

    CommonResult<UmsUser> updateUserInfo(UmsUser user);
}
