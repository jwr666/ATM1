package com.jwr.atm.settings.service.impl;

import com.jwr.atm.settings.dao.TransactionDao;
import com.jwr.atm.settings.domain.Transaction;
import com.jwr.atm.settings.service.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private TransactionDao transactionDao;

    public void setTransactionDao(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Override
    public boolean log(Transaction t) {
        boolean flag=true;
        int count= transactionDao.log(t);
        if (count!=1){
            flag=false;
        }
        return flag;
    }

    @Override
    public List<Transaction> getTransactionList(String accountId) {
        List<Transaction> tList=transactionDao.getTransactionList(accountId);
        return tList;
    }
}
