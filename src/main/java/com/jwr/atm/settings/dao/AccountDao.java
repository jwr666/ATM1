package com.jwr.atm.settings.dao;

import com.jwr.atm.settings.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AccountDao {


    Account login(Map<String, String> map);

    String search(String myAccount);

    int save(String myAccount, String saveMoney);

    int draw(String myAccount, String drawMoney);

    int update(@Param("accountId")String accountId, @Param("totalMoney") String totalMoney);
}
