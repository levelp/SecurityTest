package com.levelp.springsec.dao;

import com.levelp.springsec.model.User;

/**
 * Created by Student-25 on 03.02.2017.
 */
public interface UserDAO {
    void register(User convert);

    User getByLogin(String s);
}
