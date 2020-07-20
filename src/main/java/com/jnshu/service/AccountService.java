package com.jnshu.service;

import com.jnshu.pojo.Account;

import java.util.List;

public interface AccountService {
    /*
    * int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    *
    * */
    int deleteByPrimaryKey(Long id);

    List<Account> selectAccount(Account record);

    Account selectByPrimaryKey(Long id);

    int insert(Account record);

    int updateByPrimaryKeySelective(Account record);


}
