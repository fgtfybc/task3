package com.jnshu.service.Impl;

import com.jnshu.dao.AccountMapper;
import com.jnshu.pojo.Account;
import com.jnshu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        accountMapper.deleteByPrimaryKey(id);
        return 1;
    }

    @Override
    public List<Account> selectAccount(Account record) {
        return accountMapper.selectAccount(record);
    }

    @Override
    public Account selectByPrimaryKey(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Account record) {
        accountMapper.insert(record);
        return 1;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        accountMapper.updateByPrimaryKeySelective(record);
        return 1;
    }


}
