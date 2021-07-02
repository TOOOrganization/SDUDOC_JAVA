package cn.edu.sdu.manager.service.serviceImpl;

import cn.edu.sdu.manager.service.Ds2UmsUserRoleRelationService;
import cn.edu.sdu.repository.ds2.UmsUserRoleRelationRepository;
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
