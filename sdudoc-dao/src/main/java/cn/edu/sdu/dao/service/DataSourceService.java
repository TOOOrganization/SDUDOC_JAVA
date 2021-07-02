package cn.edu.sdu.dao.service;

import cn.edu.sdu.dao.interfaces.DataSourceName;
import cn.edu.sdu.dao.interfaces.TargetDataSource;
import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.repository.ds1.UmsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSourceService {

    @Autowired
    UmsUserRepository repository;

    public List<UmsUser> findDs2() {
        return repository.findAll();
    }

    @TargetDataSource(name = DataSourceName.EDITOR)
    public List<UmsUser> findDs1() {
        return repository.findAll();
    }
}
