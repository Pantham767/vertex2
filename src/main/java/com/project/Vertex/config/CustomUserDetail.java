package com.project.Vertex.config;

import com.project.Vertex.entity.Register;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {
    private Register Reg;
    public CustomUserDetail(Register Reg) {
        super();
        this.Reg = Reg;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() ->Reg.getRole());
    }

    @Override
    public String getPassword() {
        return Reg.getPassword();
    }

    @Override
    public String getUsername() {

        System.out.println(Reg.getEmail());
        return Reg.getEmail();
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
