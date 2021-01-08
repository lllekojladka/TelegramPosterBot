package ru.telegram.bot.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class User implements UserDetails {

    private String username;
    private String password;
    private String userIp;

    private Collection<? extends GrantedAuthority> authorities;

    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }


    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }


    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
