package cn.edu.sdu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoUserController {

    // 能否访问无权限资源
    @GetMapping(value = "/test")
    public String test() {
        return "Hello Spring Security";
    }

    // 指定权限为user才能访问，这里只能填子角色，可以填多个，在hasAnyRole里用逗号扩展
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping(value = "/testNeed")
    public String testNeed() {
        return "testNeed";
    }

}
