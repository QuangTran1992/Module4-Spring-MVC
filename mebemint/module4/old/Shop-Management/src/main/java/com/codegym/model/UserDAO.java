package com.codegym.model;


import com.codegym.repository.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users;

    static {
        users = new ArrayList<>();

        User u1 = new User();
        u1.setUserName("admin");
        u1.setPassWord("123456");
        users.add(u1);

        User u2 = new User();
        u2.setUserName("shop");
        u2.setPassWord("123456");
        users.add(u2);

    }

    public static User checkLogin(Login login) {
        for (User u : users
        ) {
            if (u.getUserName().equals(login.getUserName())
                    && u.getPassWord().equals(login.getPassWord())) {
                return u;
            }
            }
        return null;
        }

}
