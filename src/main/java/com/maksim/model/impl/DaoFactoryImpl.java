package com.maksim.model.impl;

import com.maksim.model.dao.DaoFactory;
import com.maksim.model.dao.UserDAO;

/**
 * Created by User on 15/01/2018.
 */
public class DaoFactoryImpl implements DaoFactory {
    private static final DaoFactoryImpl FACTORY = new DaoFactoryImpl();

    private DaoFactoryImpl(){}

    public static DaoFactoryImpl getInstance() {
        return FACTORY;
    }
    @Override
    public UserDAO getUserDao() {
        return UserDaoImpl.getInstance();
    }

//    @Override
//    public UserDAO getUserDao() {
//        return UserDaoImpl.getInstance();
//    }
}
