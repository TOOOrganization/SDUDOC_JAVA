package cn.edu.sdu.service;

import cn.edu.sdu.component.EditorRoleForUserVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "editorAuthorityService")
public interface EditorAuthorityService {

    /**
     * 查询用户的所有角色
     *
     * @param userId 查询用户id
     * @return 用户的所有角色
     *
     * */
    List<EditorRoleForUserVo> selectRoleForUser(Integer userId);

}
