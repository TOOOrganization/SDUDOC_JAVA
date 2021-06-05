package cn.edu.sdu.component;

import cn.edu.sdu.entity.ds1.UmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityUserDetails extends UmsUser implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

    private UmsUser user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public SecurityUserDetails(UmsUser user, Collection<? extends GrantedAuthority> authorities){
        this.user = user;
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setAuthorities(authorities);
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

    public SecurityUserDetails setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        return this;
    }

    public UmsUser getUser() {
        return user;
    }
}
