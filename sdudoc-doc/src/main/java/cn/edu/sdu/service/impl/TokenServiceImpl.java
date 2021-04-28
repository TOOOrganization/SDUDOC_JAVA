package cn.edu.sdu.service.impl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
import cn.edu.sdu.service.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(UmsUser user) {
        String token = "";
        token = JWT.create().withAudience(user.getUid().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
