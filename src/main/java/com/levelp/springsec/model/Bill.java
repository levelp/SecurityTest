package com.levelp.springsec.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Счёт
 */
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    BigDecimal balance = new BigDecimal("0.0");

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
}
