package cn.edu.sdu.editor.controller;

import cn.edu.sdu.editor.service.EditorUserDetailsService;
import cn.edu.sdu.common.api.CommonResult;
import cn.edu.sdu.entity.ds1.UmsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    @Qualifier(value = "editorUserDetailsService")
    EditorUserDetailsService userDetailsService;

    @PostMapping("/login")
    public CommonResult<String> login(String username, String password) {
        return userDetailsService.login(username, password);
    }

    @PostMapping("/register")
    public CommonResult<String> register(String username, String password, String nickname) {
        return userDetailsService.register(username, password, nickname);
    }

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @PostMapping("/set_password")
    public CommonResult<String> setPassword(String username, String password, String confirmPassword) {
        return userDetailsService.setPassword(username, password, confirmPassword);
    }

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @PostMapping("/get_by_username")
    public CommonResult<UmsUser> getByUsername(String username) {
        return userDetailsService.getByUsername(username);
    }

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @PostMapping("/get_by_id")
    public CommonResult<UmsUser> getById(Integer id) {
        return userDetailsService.getById(id);
    }

    @PreAuthorize("hasAnyRole('administrator_editor', 'author')")
    @PostMapping("/update_user_info")
    public CommonResult<UmsUser> updateUserInfo(@RequestBody UmsUser user) {
        return userDetailsService.updateUserInfo(user);
    }
}
