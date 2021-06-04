package cn.edu.sdu.controller;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsUser;
import cn.edu.sdu.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    // 这里要指定注入的UserDetailsService
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // 简单的登录，可以照搬doc里的逻辑
    @PostMapping(value = "/login")
    public String login(@RequestBody UmsUser user, HttpServletRequest request){
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    // 能否访问默认资源
    @PostMapping("haha")
    public String haha(){
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return "haha:" + userDetails.getUsername() + "," + userDetails.getPassword();
        } catch (Exception e) {
            return "500";
        }
    }
}
