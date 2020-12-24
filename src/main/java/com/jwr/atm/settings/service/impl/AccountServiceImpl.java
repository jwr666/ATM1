package com.jwr.atm.settings.service.impl;

import com.jwr.atm.exception.LoginException;
import com.jwr.atm.settings.dao.AccountDao;
import com.jwr.atm.settings.dao.UserDao;
import com.jwr.atm.settings.domain.Account;
import com.jwr.atm.settings.service.AccountService;
import com.jwr.atm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService {
   private AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public Account login(String loginAct, String loginPwd) throws LoginException {
        Map<String,String> map=new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        Account account=accountDao.login(map);

        if (account==null){
            throw new LoginException("账号密码错误");
        }
        return account;
    }

    @Override
    public String search(String myAccount) {
        String balance=accountDao.search(myAccount);

        return balance;
    }



    @Override
    public boolean update(String accountId,String totalMoney) {
        boolean flag=true;
        int count=accountDao.update(accountId,totalMoney);
        if (count!=1){
            flag=false;
        }

        return flag;
    }


}
