import com.jwr.atm.exception.LoginException;
import com.jwr.atm.settings.domain.Account;
import com.jwr.atm.settings.service.AccountService;
import com.jwr.atm.settings.service.impl.AccountServiceImpl;
import com.jwr.atm.utils.ServiceFactory;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    @Test
    public void test01() throws LoginException {
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        AccountServiceImpl as= (AccountServiceImpl) ctx.getBean("AccountService");
        String balance=as.search("A1003");
        System.out.println(balance);
    }

}
