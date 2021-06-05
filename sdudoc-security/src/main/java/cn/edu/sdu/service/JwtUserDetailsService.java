package cn.edu.sdu.service;

import cn.edu.sdu.entity.ds1.UmsUser;
import cn.edu.sdu.repository.ds1.UmsUserRepository;
import cn.edu.sdu.component.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    UmsUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsUser user = repository.findByUsername(username).get(0);

        List<GrantedAuthority> authorityList = new ArrayList<>();
        // 查出来user的role放到authorityList里
        authorityList.add(new SimpleGrantedAuthority("ROLE_user"));

        return new SecurityUserDetails(user, authorityList);
    }
}
