package com.levelp.springsec.controllers;

import com.levelp.springsec.model.Account;
import com.levelp.springsec.model.Bill;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Student-25 on 03.02.2017.
 */
@Controller
public class HelloController {

    @Autowired
    private SessionFactory factory;

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ModelAndView("index", "name", user.getUsername());
    }

    @RequestMapping(value = "/")
    @Transactional
    public String index() {
        Session session = factory.openSession();
        Account account = new Account();
        account.setName("account1");
        List<Bill> list = account.getBills();

        Bill b1 = new Bill();
        list.add(b1);
        b1.setBalance(new BigDecimal("1.0"));
        b1.setAccount(account);

        Bill b2 = new Bill();
        list.add(b2);
        b2.setBalance(new BigDecimal("2.0"));
        b2.setAccount(account);

        session.save(account);
        session.save(b1);
        session.save(b2);

        //session.close();

        return "empty_page";
    }

    @RequestMapping(value = "/delete")
    @Transactional
    public String delete() { // int accountId
        // Удаление подчинённых объектов
        Session session = factory.openSession();
        Account account = (Account) session.createQuery("from Account where id = 6")
                .uniqueResult();

        Query query = session.createQuery("delete Bill where id >= 7 and id <= 9");
        int result = query.executeUpdate();
        if (result > 0) {
            System.out.println("Expensive products was removed");
        }

        // Получаем первый счёт
        List<Bill> list = account.getBills();
        if (list.size() > 0) {
            Bill b1 = list.get(0);
            if (b1 != null) {
                System.out.println("b1.getId() = " + b1.getId());
                b1.setBalance(new BigDecimal("11.11"));
                session.delete(b1);
                session.flush();
            }
        }

        return "empty_page";
    }
}
