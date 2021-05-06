package cn.edu.sdu.sdudoc.sdudocmysql.service;


import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;

public interface TokenService {
    String getToken(UmsUser user);
}
