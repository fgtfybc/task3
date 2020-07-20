package com.jnshu.service;

import com.jnshu.pojo.Module;

import java.util.List;

public interface ModuleService {

    int deleteByPrimaryKey(Long id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> selectModule(Module record);
}
