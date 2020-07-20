package com.jnshu.controller;

import com.jnshu.pojo.Account;
import com.jnshu.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {
    private static final Logger logger = LogManager.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    /*查询*/
    @GetMapping("/Account")
    @ResponseBody
    public Map<String,Object> selectAccount(Account account){
        logger.info("查询账户 :" + account);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Account> list = accountService.selectAccount(account);
            if(list.isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","不存在");
            }else {
                resultMap.put("code", 200);
                resultMap.put("msg", "查询成功");
                resultMap.put("data", list);
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select account error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/Account")//新增账户
    public Map<String,Object> insertAccount(Account account){
        logger.info("add username is :" + account);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            account.setCreatby("管理员");
            account.setCreatat(time);
            account.setUpdateby("管理员");
            account.setUpdateat(time);
            accountService.insert(account);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add account error");
        }
        return resultMap;
    }

    @DeleteMapping("/Account/{id}")//删除账户
    @ResponseBody
    public Map<String,Object> deleteAccount(@PathVariable Long id){
        logger.info("delete account's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Account account = new Account();
        account.setId(id);
        try {
            if(accountService.selectAccount(account).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该账户不存在！");
            }else {
                accountService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete account error");
        }
        return resultMap;
    }

    @PutMapping("/Account/{id}")//编辑账户
    @ResponseBody
    public Map<String,Object> updateAccount(@PathVariable Long id,Account account){
        logger.info("update account's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Account account1 = new Account();
        account1.setId(id);
        try {
            if(accountService.selectAccount(account1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该账号不存在");
            }else {
                accountService.updateByPrimaryKeySelective(account);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update account error");
        }
        return resultMap;
    }
}

