package com.jwr.atm.settings.service;

import com.jwr.atm.exception.LoginException;
import com.jwr.atm.settings.domain.Account;

public interface AccountService {

    Account login(String loginAct,String loginPwd) throws LoginException;

    String search(String myAccount);



    boolean update(String accountId,String totalMoney);
}
