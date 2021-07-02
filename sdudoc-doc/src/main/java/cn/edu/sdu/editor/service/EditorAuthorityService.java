package cn.edu.sdu.editor.service;

import cn.edu.sdu.editor.component.EditorRoleForUserVo;

import java.util.List;

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
