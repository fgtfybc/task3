package com.jnshu.service;

import com.jnshu.pojo.Works;

import java.util.List;

public interface WorksService {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKeyWithBLOBs(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectWorks(Works record);
}
