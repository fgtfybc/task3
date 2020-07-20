package com.jnshu.service;

import com.jnshu.pojo.WorksList;

import java.util.List;

public interface WorksListService {
    int deleteByPrimaryKey(Long id);

    int insert(WorksList record);

    int insertSelective(WorksList record);

    WorksList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorksList record);

    int updateByPrimaryKey(WorksList record);

    List<WorksList> selectWorksList(WorksList record);
}
