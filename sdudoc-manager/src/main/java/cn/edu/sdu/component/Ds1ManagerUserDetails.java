package cn.edu.sdu.component;

import cn.edu.sdu.entity.ds1.UmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Ds1ManagerUserDetails implements UserDetails {

    private UmsUser umsUser;

    private Collection<? extends GrantedAuthority> authorities;

    public Ds1ManagerUserDetails(){};

    public Ds1ManagerUserDetails(UmsUser umsUser, Collection<? extends GrantedAuthority> authorities) {
        this.umsUser = umsUser;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return umsUser.getPassword();
    }

    @Override
    public String getUsername() {
        return umsUser.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
