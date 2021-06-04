package cn.edu.sdu.sdudoc.sdudocsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoUserController {

    @GetMapping(value = "/test")
    public String test() {
        return "Hello Spring Security";
    }

    @PreAuthorize("hasAnyRole('user')")
    @PostMapping(value = "/testNeed")
    public String testNeed() {
        return "testNeed";
    }

}
