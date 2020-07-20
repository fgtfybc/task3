import com.jnshu.controller.AccountController;
import com.jnshu.pojo.Account;
import com.jnshu.service.AccountService;
import net.sf.json.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-applicationContext.xml"})
public class AccountDaoTest {
    private static final Logger logger = LogManager.getLogger(AccountDaoTest.class);

    @Autowired
    private AccountService accountService;

    @Test
    public void add(){
        Account account = new Account();
        account.setId(1L);
        account.setName("宋超");
        account.setPwd("1234");
        account.setRole("市场");
        account.setCreatby("管理员1");
        account.setCreatat(20200618L);
        account.setUpdateby("管理员");
        account.setUpdateat(20200618L);
        accountService.insert(account);
    }

   /* @Test
    public void del(){
        accountService.deleteByPrimaryKey(2L);
    }

    @Test
    public void update(){
        Account account = new Account();
        account.setId(3L);
        account.setName("lisi");
        accountService.updateByPrimaryKeySelective(account);
    }

    @Test
    public void get(){
        Account account = new Account();
        account.setName("lisi");
        List<Account> list =  accountService.selectAccount(account);
        JSONArray jsonArray =JSONArray.fromObject(list);
        System.out.println(jsonArray);
    }*/
}
