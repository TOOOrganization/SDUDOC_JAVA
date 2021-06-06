package cn.edu.sdu.service.impl;

import cn.edu.sdu.component.EditorRoleForUserVo;
import cn.edu.sdu.service.EditorAuthorityService;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service(value = "editorAuthorityService")
public class EditorAuthorityServiceImpl implements EditorAuthorityService {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<EditorRoleForUserVo> selectRoleForUser(Integer userId) {
        List<EditorRoleForUserVo> resultList = new ArrayList<>();
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
                .setResultTransformer(Transformers.aliasToBean(EditorRoleForUserVo.class))
                .getResultList();

        list.forEach(item -> {
            resultList.add((EditorRoleForUserVo) item);
        });

        return resultList;
    }

}
