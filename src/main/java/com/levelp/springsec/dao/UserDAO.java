package com.levelp.springsec.dao;

import com.levelp.springsec.model.User;

public interface UserDAO {
    void register(User convert);

    User getByLogin(String s);
}
