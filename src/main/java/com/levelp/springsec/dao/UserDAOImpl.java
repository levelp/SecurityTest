package com.levelp.springsec.dao;

import com.levelp.springsec.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Student-25 on 03.02.2017.
 */
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory factory;

    @Transactional
    @Override
    public void register(User convert) {
        Session session = factory.openSession();
        session.save(convert);
    }

    @Override
    public User getByLogin(String s) {
        Session session = factory.openSession();
        User user = (User) session.createQuery("from User where login=:login")
                .setParameter("login", s)
                .uniqueResult();
        return user;
    }
}
