package com.levelp.springsec.service;

import com.levelp.springsec.dao.UserDAO;
import com.levelp.springsec.dto.UserRegistrationDTO;
import com.levelp.springsec.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Student-25 on 03.02.2017.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void register(UserRegistrationDTO dto) {
        dao.register(convert(dto));
    }

    private User convert(UserRegistrationDTO dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setPassword(encoder.encode(dto.getPassword()));

        return user;
    }
}
