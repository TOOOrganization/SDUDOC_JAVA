package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.component.JpaRightForRoleVo;
import cn.edu.sdu.component.JpaRoleForUserVo;
import cn.edu.sdu.entity.ds1.*;
import cn.edu.sdu.repository.ds1.*;
import cn.edu.sdu.service.Ds1AuthorityManagementService;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service(value = "Ds1AuthorityManagementService")
public class Ds1AuthorityManagementServiceImpl implements Ds1AuthorityManagementService {

    @Qualifier("ds1EntityManager")
    @Autowired
    EntityManager entityManager;

    @Autowired
    UmsRoleRepository roleRepository;

    @Autowired
    UmsUserRepository userRepository;

    @Autowired
    UmsRightRepository rightRepository;

    @Autowired
    UmsUserRoleRelationRepository userRoleRelationRepository;

    @Autowired
    UmsRoleRightRelationRepository roleRightRelationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UmsRole> selectParentRole(Integer roleId) {
        List<UmsRole> resultList = new ArrayList<>();
        StringBuilder sql_select_parent_role = new StringBuilder();

        sql_select_parent_role
                .append("SELECT * FROM ums_role ")
                .append("WHERE parent_rid = ")
                .append("(SELECT parent_rid FROM ums_role WHERE rid = ")
                .append(roleId)
                .append(" )");

        Query query = entityManager.createNativeQuery(sql_select_parent_role.toString());
        List list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(UmsRole.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((UmsRole) item);
        });

        return resultList;
    }

    @Override
    public List<UmsRight> selectParentRight(Integer rightId) {
        List<UmsRight> resultList = new ArrayList<>();
        StringBuilder sql_select_parent_right = new StringBuilder();

        sql_select_parent_right
                .append("SELECT * FROM ums_right ")
                .append("WHERE parent_right_id = ")
                .append("(SELECT parent_right_id FROM ums_right WHERE right_id = ")
                .append(rightId)
                .append(" )");

        Query query = entityManager.createNativeQuery(sql_select_parent_right.toString());
        List list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(UmsRole.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((UmsRight) item);
        });

        return resultList;
    }

    @Override
    public List<JpaRightForRoleVo> selectRightForRole(Integer roleId) {
        List<JpaRightForRoleVo> resultList = new ArrayList<>();
        StringBuilder sql_select_right_for_role = new StringBuilder();

        sql_select_right_for_role
                .append("select ")
                .append("r.rid rid, r.`name` `role_name`, a.right_id right_id, a.`name` right_name, r.description role_description, a.description right_description, rr.right_type right_type ")
                .append("from ")
                .append("ums_role r ")
                .append("left join ums_role_right_relation rr on r.rid = rr.rid ")
                .append("left join ums_right a on rr.right_id = a.right_id ")
                .append("where ")
                .append("r.rid = ")
                .append(roleId);

        Query query = entityManager.createNativeQuery(sql_select_right_for_role.toString());
        List list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(JpaRightForRoleVo.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((JpaRightForRoleVo) item);
        });

        return resultList;
    }

    @Override
    public List<JpaRoleForUserVo> selectRoleForUser(Integer userId) {
        List<JpaRoleForUserVo> resultList = new ArrayList<>();
        StringBuilder sql_select_role_for_user = new StringBuilder();

        sql_select_role_for_user
                .append("select ")
                .append("u.uid uid, u.username username, r.rid rid, r.`name` role_name, r.description role_description ")
                .append("from ")
                .append("ums_user u ")
                .append("left join ums_user_role_relation ur on u.uid = ur.uid ")
                .append("left join ums_role r on ur.rid = r.rid ")
                .append("where ")
                .append("u.uid = ")
                .append(userId);

        Query query = entityManager.createNativeQuery(sql_select_role_for_user.toString());
        List list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(JpaRoleForUserVo.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((JpaRoleForUserVo) item);
        });

        return resultList;
    }

    @Override
    public Integer saveRole(UmsRole role, Integer... rightIds) {

        UmsRole resultRole = insertRole(role);
        Integer result = resultRole.getRid();

        for (Integer rightId : rightIds) {
            if (!authorizeRole(result, rightId)) {
                return -1;
            }
        }

        return result;
    }

    @Override
    public Integer saveUser(UmsUser user, Integer... roleIds) {

        UmsUser resultUser = insertUser(user);
        Integer result = resultUser.getUid();

        for (Integer roleId : roleIds) {
            if (!authorizeUser(result, roleId)) {
                return -1;
            }
        }

        return result;
    }

    @Override
    public Boolean authorizeUser(Integer userId, Integer roleId) {

        UmsUserRoleRelation relation = new UmsUserRoleRelation();

        relation.setUid(userId);
        relation.setRid(roleId);

        return insertUserRoleRelation(relation).getUrid() != null;
    }

    @Override
    public Boolean authorizeRole(Integer roleId, Integer rightId) {

        UmsRoleRightRelation relation = new UmsRoleRightRelation();

        relation.setRid(roleId);
        relation.setRightId(rightId);
        relation.setRightType(false);
        
        return insertRoleRightRelation(relation).getRrid() != null;
    }

    private UmsRole insertRole(UmsRole role) {

        return roleRepository.save(role);
    }

    private UmsUser insertUser(UmsUser user) {

        return userRepository.save(user);
    }

    private UmsRight insertRight(UmsRight right) {

        return rightRepository.save(right);
    }

    private UmsUserRoleRelation insertUserRoleRelation(UmsUserRoleRelation relation) {

        return userRoleRelationRepository.save(relation);
    }

    private UmsRoleRightRelation insertRoleRightRelation(UmsRoleRightRelation relation) {

        return roleRightRelationRepository.save(relation);
    }
}
