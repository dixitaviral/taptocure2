package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Slf4j
public class CustomUserDetails implements UserDetails {
    private User user;
    public CustomUserDetails(User user)
    {
        this.user=user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(user.getRole());
        List<GrantedAuthority>authorities=new ArrayList<>();
        authorities.add(simpleGrantedAuthority);
        log.info("Inside the method of getAuthorities() of CustomUserDetails class");
        return authorities;
    }

    @Override
    public String getPassword() {
        log.info("Inside getPassword() method of CustomUserDetails class");
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("Inside getUserName() method of CustomUserDetails class");
        return user.getEmail();
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
