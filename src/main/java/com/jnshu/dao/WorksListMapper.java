package com.jnshu.dao;


import com.jnshu.pojo.WorksList;

import java.util.List;

public interface WorksListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorksList record);

    int insertSelective(WorksList record);

    WorksList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorksList record);

    int updateByPrimaryKey(WorksList record);

    List<WorksList> selectWorksList(WorksList record);
}