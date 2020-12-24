package com.jwr.atm.settings.service.impl;

import com.jwr.atm.settings.dao.UserDao;
import com.jwr.atm.settings.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String searchName(String ownerId) {
        String name=userDao.searchName(ownerId);

        return name;
    }
}
