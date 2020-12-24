package com.jwr.atm.settings.web.controller;

import com.jwr.atm.exception.LoginException;
import com.jwr.atm.settings.domain.Account;
import com.jwr.atm.settings.domain.Transaction;
import com.jwr.atm.settings.service.impl.AccountServiceImpl;
import com.jwr.atm.settings.service.impl.TransactionServiceImpl;
import com.jwr.atm.settings.service.impl.UserServiceImpl;
import com.jwr.atm.utils.DateTimeUtil;
import com.jwr.atm.utils.PrintJson;
import com.jwr.atm.utils.UUIDUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {
    String config="applicationContext.xml";
    ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
    AccountServiceImpl as= (AccountServiceImpl) ctx.getBean("AccountService");
    UserServiceImpl us= (UserServiceImpl) ctx.getBean("UserService");
    TransactionServiceImpl ts=(TransactionServiceImpl) ctx.getBean("TransactionService");
    private static Logger logger=Logger.getLogger(MyController.class);
    @RequestMapping(value = "/settings/account/login.do")
    public void login(String loginAct,String loginPwd,HttpServletRequest req, HttpServletResponse resp){
        System.out.println("处理settings/account/login.do");

/*        String loginAct=req.getParameter("loginAct");
        String loginPwd=req.getParameter("loginPwd");*/

        try {
            Account account=as.login(loginAct,loginPwd);
                String msg="用户"+loginAct+"登陆";
                logger.info(msg);

            //将account账户存入session域中，使得本次会话中其他页面也可使用account
             HttpSession session=req.getSession();
            session.setAttribute("account",account);
            String name=us.searchName(account.getAccountOwnerId());
            session.setAttribute("name",name);
            System.out.println("account已经存入session域中");
            Account a= (Account) req.getSession().getAttribute("account");
            System.out.println(a.getAccountId());



            PrintJson.printJsonFlag(resp,true);
        } catch (LoginException e) {
            e.printStackTrace();


            String msg=e.getMessage();

            Map<String,Object> map=new HashMap<>();
            map.put("success",false);
            map.put("msg",msg);
            PrintJson.printJsonObj(resp,map);

        }

    }
    @RequestMapping(value = "/settings/account/search.do")
    public void search(String accountId,HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入余额查询操作");
        String balance=as.search(accountId);
        String msg="用户"+accountId+"进行余额查询操作";
        logger.info(msg);
        PrintJson.printJsonObj(resp,balance);
    }
    @RequestMapping(value = "/settings/account/save.do")
    public void save(String accountId,String money,HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入存款操作");
        Map<String,Object> map=new HashMap<>();

        String balance=as.search(accountId);
        String totalMoney=String.format("%.2f",Double.parseDouble(money)+Double.parseDouble(balance));
        boolean flag=as.update(accountId,totalMoney);

        if (flag){
            Transaction t=new Transaction();
            t.setTransactionAccountId(accountId);
            t.setTransactionId(UUIDUtil.getUUID());
            t.setTransactionBalance(totalMoney);
            t.setTransactionDate(DateTimeUtil.getSysTime());
            t.setTransactionType("存款");
            t.setTransactionInCome(money);
            t.setTransactionExpend(" ");
            t.setTransactionTo(" ");

            ts.log(t);
            System.out.println("交易记录+1");
            String msg="用户"+accountId+"进行存款操作"+"金额为："+money;
            logger.info(msg);
        }
        map.put("success",flag);
        map.put("msg",totalMoney);
        PrintJson.printJsonObj(resp,map);
    }
    @RequestMapping(value = "/settings/account/draw.do")
    public void draw(String accountId,String money,HttpServletRequest req, HttpServletResponse resp){

        System.out.println("进入取款操作");
        boolean flag;
        Map<String,Object> map=new HashMap<>();
        String balance=as.search(accountId);
        Double TotalMoney=Double.parseDouble(balance)-Double.parseDouble(money);
        //判断要取得金额是否大于总账户余额
        if (TotalMoney>0){
            String totalMoney=String.format("%.2f",TotalMoney);
            flag=as.update(accountId,totalMoney);
            if (flag){
                Transaction t=new Transaction();
                t.setTransactionAccountId(accountId);
                t.setTransactionId(UUIDUtil.getUUID());
                t.setTransactionBalance(totalMoney);
                t.setTransactionDate(DateTimeUtil.getSysTime());
                t.setTransactionType("取款");
                t.setTransactionExpend(money);
                t.setTransactionInCome(" ");
                t.setTransactionTo(" ");

                ts.log(t);
                System.out.println("交易记录+1");
                String msg="用户"+accountId+"进行取款操作"+"金额为："+money;
                logger.info(msg);
            }

            map.put("success",flag);
            map.put("msg",totalMoney);
            PrintJson.printJsonObj(resp,map);
        }else{
//            req.getSession().setAttribute("msg_drawAccount","账户余额不足");
            map.put("success",false);
            map.put("msg","账户余额不足");
            PrintJson.printJsonObj(resp,map);

        }
    }
    @RequestMapping(value = "/settings/account/transfer.do")
    public void transfer(String accountId,String toAccount,String toMoney,HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入转账操作");
        boolean flag;
        Map<String,Object> map=new HashMap<>();

        //本账户余额
        String myBalance=as.search(accountId);
        //对方账户余额
        String toBalance=as.search(toAccount);
        System.out.println(toBalance);
        if (toBalance==null){
            map.put("success",false);
            map.put("msg","对方账户不存在");
            PrintJson.printJsonObj(resp,map);
            return;
        }
        if (accountId.equals(toAccount)){
            map.put("success",false);
            map.put("msg","不能自己给自己转");
            PrintJson.printJsonObj(resp,map);
            return;
        }

        Double myTotalMoney=Double.parseDouble(myBalance)-Double.parseDouble(toMoney);
        Double toTotalMoney=Double.parseDouble(toBalance)+Double.parseDouble(toMoney);
        //判断要取得金额是否大于总账户余额
        if (myTotalMoney>0){
            String mytotalMoney=String.format("%.2f",myTotalMoney);
            String tototalMoney=String.format("%.2f",toTotalMoney);
            flag=as.update(accountId,mytotalMoney);
            if (flag){
                flag=as.update(toAccount,tototalMoney);
                if (flag){
                    Transaction t=new Transaction();
                    t.setTransactionAccountId(accountId);
                    t.setTransactionId(UUIDUtil.getUUID());
                    t.setTransactionBalance(mytotalMoney);
                    t.setTransactionDate(DateTimeUtil.getSysTime());
                    t.setTransactionType("转账");
                    t.setTransactionExpend(toMoney);
                    t.setTransactionTo(toAccount);
                    t.setTransactionInCome(" ");

                    ts.log(t);
                    System.out.println("交易记录+1");

                    Transaction t2=new Transaction();
                    t2.setTransactionAccountId(toAccount);
                    t2.setTransactionId(UUIDUtil.getUUID());
                    t2.setTransactionBalance(tototalMoney);
                    t2.setTransactionDate(DateTimeUtil.getSysTime());
                    t2.setTransactionType("来自他人的转账");
                    t2.setTransactionExpend(" ");
                    t2.setTransactionTo(accountId);
                    t2.setTransactionInCome(toMoney);

                    ts.log(t2);
                    System.out.println("交易记录+1");

                    String msg="用户"+accountId+"进行转账操作"+"金额为："+toMoney;
                    logger.info(msg);
                }

            }

            map.put("success",flag);
            map.put("msg",mytotalMoney);
            PrintJson.printJsonObj(resp,map);
        }else{
//            req.getSession().setAttribute("msg_drawAccount","账户余额不足");
            map.put("success",false);
            map.put("msg","账户余额不足");
            PrintJson.printJsonObj(resp,map);

        }

    }
    @RequestMapping(value = "/settings/transaction/transactionList.do")
    public void transactionList(String accountId,HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入交易历史列表展示操作");

        List<Transaction> tList=ts.getTransactionList(accountId);

        PrintJson.printJsonObj(resp,tList);
        String msg="用户"+accountId+"进行交易记录查询操作";
        logger.info("msg");


    }
}
