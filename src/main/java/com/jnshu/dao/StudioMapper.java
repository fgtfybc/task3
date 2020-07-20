package com.jnshu.dao;

import com.jnshu.pojo.Role;
import com.jnshu.pojo.Studio;

import java.util.List;

public interface StudioMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKeyWithBLOBs(Studio record);

    int updateByPrimaryKey(Studio record);

    List<Studio> selectStudio(Studio record);
}