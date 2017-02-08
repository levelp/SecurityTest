package com.levelp.springsec.dto;

/**
 * Created by Student-25 on 03.02.2017.
 */
public class UserRegistrationDTO {
    private String login;
    private String password;
    private String confirmation;

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

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
}
