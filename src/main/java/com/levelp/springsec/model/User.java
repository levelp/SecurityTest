package com.levelp.springsec.model;

import javax.persistence.*;

/**
 * Created by Student-25 on 03.02.2017.
 */
@Entity
@Table(name = "accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "login", unique = true, nullable = false, columnDefinition = "varchar(50)")
    private String login;
    @Column(name = "password", nullable = false, columnDefinition = "varchar(60)")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
