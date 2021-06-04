package cn.edu.sdu;

import cn.edu.sdu.controller.Ds2AuthorityManagementController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AuthorityTest {

    @Autowired
    Ds2AuthorityManagementController ds2AuthorityManagementController;

    @Test
    public void selectRoleForUser(){
        System.out.println(ds2AuthorityManagementController.selectRoleForUser(13));
    }
}
