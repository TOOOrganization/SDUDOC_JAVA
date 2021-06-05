package cn.edu.sdu;

import cn.edu.sdu.controller.Ds2AuthorityManagementController;
import cn.edu.sdu.controller.Ds2UmsUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AuthorityTest {

    @Autowired
    Ds2UmsUserController ds2UmsUserController;

    @Autowired
    Ds2AuthorityManagementController ds2AuthorityManagementController;

    @Test
    public void findAll(){
        ds2UmsUserController.findAll();
    }

    @Test
    public void selectRoleForUser(){
        System.out.println(ds2AuthorityManagementController.selectRoleForUser(13).getData());
    }

    @Test
    public void selectRightForRole(){
        System.out.println(ds2AuthorityManagementController.selectRightForRole(5).getData());
    }
}
