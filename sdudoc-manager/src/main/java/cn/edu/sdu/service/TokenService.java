package cn.edu.sdu.service;


import cn.edu.sdu.entity.ds2.UmsUser;

public interface TokenService {
    String getToken(UmsUser user);
}
