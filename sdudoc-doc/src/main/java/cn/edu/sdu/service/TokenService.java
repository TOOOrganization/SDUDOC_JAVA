package cn.edu.sdu.service;

import cn.edu.sdu.sdudoc.sdudocdao.entity.UmsUser;

public interface TokenService {
    String getToken(UmsUser user);
}
