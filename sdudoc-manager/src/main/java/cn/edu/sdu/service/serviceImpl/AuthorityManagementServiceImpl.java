package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.component.JpaRightForRoleVo;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsRight;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsRole;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsUser;
import cn.edu.sdu.service.AuthorityManagementService;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service(value = "AuthorityManagementService")
public class AuthorityManagementServiceImpl implements AuthorityManagementService {

    @Autowired
    EntityManager entityManager;

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
                .append("r.rid rid, r.`name` `role_name`, a.right_id right_id, a.`name` right_name, r.description role_description, a.description right_description ")
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
    public List<UmsRole> selectRoleForUser(Integer userId) {
        List<UmsRole> resultList = new ArrayList<>();
        StringBuilder sql_select_role_for_user = new StringBuilder();

        sql_select_role_for_user
                .append("select ")
                .append("u.uid uid, u.username username, r.rid rid, r.`name` role_name, r.description role_description ")
                .append("from ")
                .append("ums_user u ")
                .append("left join ums_user_role_relation ur on r.uid = ur.uid ")
                .append("left join ums_role r on ur.rid = r.rid ")
                .append("where ")
                .append("u.uid = ")
                .append(userId);

        Query query = entityManager.createNativeQuery(sql_select_role_for_user.toString());
        List list = query.unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.aliasToBean(UmsRole.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((UmsRole) item);
        });

        return resultList;
    }

    @Override
    public Integer saveRole(UmsRole role, Integer... rightIds) {
        return null;
    }

    @Override
    public Integer saveUser(UmsUser user, Integer... roleIds) {
        return null;
    }

    @Override
    public Boolean authorizeUser(Integer userId, Integer roleId) {
        return null;
    }

    @Override
    public Boolean authorizeRole(Integer roleId, Integer rightId) {
        return null;
    }
}
