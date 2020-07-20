package com.jnshu.dao;

import com.jnshu.pojo.Works;
import com.jnshu.pojo.WorksList;

import java.util.List;

public interface WorksMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Works record);

    int insertSelective(Works record);

    Works selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKeyWithBLOBs(Works record);

    int updateByPrimaryKey(Works record);

    List<Works> selectWorks(Works record);
}