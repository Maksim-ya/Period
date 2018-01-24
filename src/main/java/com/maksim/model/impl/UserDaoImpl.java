package com.maksim.model.impl;

import com.maksim.domain.User;
import com.maksim.model.dao.UserDAO;


import java.util.List;

public class UserDaoImpl implements UserDAO {


    private final static UserDaoImpl userDao = new UserDaoImpl();

    public UserDaoImpl() {
    }

    static UserDaoImpl getInstance(){return userDao;}

    public void addUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void removeUser(int id) {

    }

    public User findByUserName(String UserName) {
        return null;
    }

    public List<User> findAllUsers() {
        return null;
    }
}