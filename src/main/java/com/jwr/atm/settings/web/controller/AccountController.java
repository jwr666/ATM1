package com.jwr.atm.settings.web.controller;

import com.jwr.atm.exception.LoginException;
import com.jwr.atm.settings.domain.Account;
import com.jwr.atm.settings.service.AccountService;
import com.jwr.atm.settings.service.impl.AccountServiceImpl;
import com.jwr.atm.utils.PrintJson;
import com.jwr.atm.utils.ServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AccountController extends HttpServlet {
    String config="applicationContext.xml";
    ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
    AccountServiceImpl as= (AccountServiceImpl) ctx.getBean("AccountService");
    /*@Override*/
    /*protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getServletPath();
        if("/settings/account/login.do".equals(path)){
            login(req,resp);
        }else if ("/settings/account/search.do".equals(path)){
            search(req,resp);
        }else if("/settings/account/save.do".equals(path)){
            save(req,resp);
        }else if ("/settings/account/draw.do".equals(path)){
            draw(req,resp);
        }
    }*/

    /*private void draw(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入取款操作");
        String myAccount=req.getParameter("myAccount");
        String drawMoney=req.getParameter("drawMoney");


        boolean flag=as.draw(myAccount,drawMoney);
        PrintJson.printJsonFlag(resp,flag);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入存款操作");
        String myAccount=req.getParameter("myAccount");
        String saveMoney=req.getParameter("saveMoney");


        boolean flag=as.save(myAccount,saveMoney);
        PrintJson.printJsonFlag(resp,flag);
    }*/

    private void search(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("进入余额查询操作");
        String myAccount=req.getParameter("myAccount");

        String balance=as.search(myAccount);
        PrintJson.printJsonObj(resp,balance);
        System.out.println("已往前端传值");

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入登陆验证操作");
        String loginAct=req.getParameter("loginAct");
        String loginPwd=req.getParameter("loginPwd");

        try {
            Account account=as.login(loginAct,loginPwd);

            req.getSession().setAttribute("account",account);

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
}
