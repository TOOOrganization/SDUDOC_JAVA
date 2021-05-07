package cn.edu.sdu.sdudoc.service;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;

public interface TokenService {
    String getToken(UmsUser user);
}
