package cn.edu.sdu.manager.service.serviceImpl;

import cn.edu.sdu.repository.ds1.UmsUserRoleRelationRepository;
import cn.edu.sdu.manager.service.Ds1UmsUserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ds1UmsUserRoleRelationServiceImpl implements Ds1UmsUserRoleRelationService {

    @Autowired
    UmsUserRoleRelationRepository umsUserRoleRelationRepository;

    @Override
    public int update(Integer userId, Integer roleId) {
        return umsUserRoleRelationRepository.update(userId, roleId);
    }
}
