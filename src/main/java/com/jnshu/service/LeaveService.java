package com.jnshu.service;

import com.jnshu.pojo.Leave;

import java.util.List;

public interface LeaveService {

    int deleteByPrimaryKey(Long id);

    int insert(Leave record);

    int insertSelective(Leave record);

    Leave selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKeyWithBLOBs(Leave record);

    int updateByPrimaryKey(Leave record);

    List<Leave> selectLeave(Leave record);
}
