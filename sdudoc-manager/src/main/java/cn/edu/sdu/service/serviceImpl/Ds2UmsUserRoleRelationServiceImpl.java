package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.entity.ds2.UmsUserRoleRelation;
import cn.edu.sdu.repository.ds2.UmsUserRoleRelationRepository;
import cn.edu.sdu.service.Ds2UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ds2UmsUserRoleRelationServiceImpl implements Ds2UmsUserRoleRelationService {

    @Autowired
    UmsUserRoleRelationRepository umsUserRoleRelationRepository;

    @Override
    public int update(Integer userId, Integer roleId) {
        return umsUserRoleRelationRepository.update(userId, roleId);
    }
}
