package cn.edu.sdu.service;

import cn.edu.sdu.component.JpaRightForRoleVo;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsRight;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsRole;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsUser;

import java.util.List;

public interface Ds2AuthorityManagementService {

    /**
     * 查询父角色的所有子角色
     *
     * @param roleId 查询角色id
     * @return 父角色的所有子角色
     *
     * */
    List<UmsRole> selectParentRole(Integer roleId);

    /**
     * 查询父权限的所有子权限
     *
     * @param rightId 查询权限id
     * @return 父权限的所有子权限
     *
     * */
    List<UmsRight> selectParentRight(Integer rightId);

    /**
     * 查询角色的所有权限
     *
     * @param roleId 查询角色id
     * @return 角色的所有权限
     *
     * */
    List<JpaRightForRoleVo> selectRightForRole(Integer roleId);

    /**
     * 查询用户的所有角色
     *
     * @param userId 查询用户id
     * @return 用户的所有角色
     *
     * */
    List<JpaRoleForUserVo> selectRoleForUser(Integer userId);

    /**
     * 插入角色并指定权限
     *
     * @param role 插入角色
     * @param rightIds 指定权限ids
     * @return 插入角色id
     *
     * */
    Integer saveRole(UmsRole role, Integer... rightIds);

    /**
     * 插入用户并指定角色
     *
     * @param user 插入用户
     * @param roleIds 指定角色ids
     * @return 插入用户id
     *
     * */
    Integer saveUser(UmsUser user, Integer... roleIds);

    /**
     * 给用户授权角色
     *
     * @param userId 授权用户
     * @param roleId 授予角色
     * @return 是否成功授权
     *
     * */
    Boolean authorizeUser(Integer userId, Integer roleId);

    /**
     * 给角色授权权限
     *
     * @param roleId 授权角色
     * @param rightId 授予权限
     * @return 是否成功授权
     *
     * */
    Boolean authorizeRole(Integer roleId, Integer rightId);
}
