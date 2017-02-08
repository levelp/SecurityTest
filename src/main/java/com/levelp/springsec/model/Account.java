package com.levelp.springsec.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(targetEntity = Bill.class, mappedBy = "account")
    List<Bill> bills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bill> getBills() {
        if (bills == null)
            bills = new ArrayList<>();
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
