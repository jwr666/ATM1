package com.jwr.atm.settings.domain;

public class Transaction {
    //所属账户Id
    private String transactionAccountId;
    //用UUID来表示交易ID
    private String transactionId;
    //交易日期 yy-mm-dd hh-ss
    private String transactionDate;
    //交易类型
    /*
        转账
        取款
        存款
     */
    private String transactionType ;
    //转账对象，若类型为存取款则无该属性
    private String transactionTo;
    //收入
    private String transactionInCome;
    //支出
    private String transactionExpend;
    //账户余额
    private String transactionBalance;


    public String getTransactionAccountId() {
        return transactionAccountId;
    }

    public void setTransactionAccountId(String transactionAccountId) {
        this.transactionAccountId = transactionAccountId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionTo() {
        return transactionTo;
    }

    public void setTransactionTo(String transactionTo) {
        this.transactionTo = transactionTo;
    }

    public String getTransactionInCome() {
        return transactionInCome;
    }

    public void setTransactionInCome(String transactionInCome) {
        this.transactionInCome = transactionInCome;
    }

    public String getTransactionExpend() {
        return transactionExpend;
    }

    public void setTransactionExpend(String transactionExpend) {
        this.transactionExpend = transactionExpend;
    }

    public String getTransactionBalance() {
        return transactionBalance;
    }

    public void setTransactionBalance(String transactionBalance) {
        this.transactionBalance = transactionBalance;
    }
}
