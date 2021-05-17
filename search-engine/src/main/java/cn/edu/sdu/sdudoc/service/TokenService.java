package cn.edu.sdu.sdudoc.service;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds2.UmsUser;

public interface TokenService {
    String getToken(UmsUser user);
}
