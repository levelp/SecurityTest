package com.levelp.springsec.service;

import com.levelp.springsec.dao.UserDAO;
import com.levelp.springsec.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

/**
 * Created by Student-25 on 03.02.2017.
 */
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO dao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = dao.getByLogin(s);
        if (user == null) {
            return null;
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
