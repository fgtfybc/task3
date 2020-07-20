package com.jnshu.service.Impl;

import com.jnshu.dao.WorksListMapper;
import com.jnshu.pojo.WorksList;
import com.jnshu.service.WorksListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksListServiceImpl implements WorksListService {

    @Autowired
    private WorksListMapper worksListMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return worksListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WorksList record) {
        return worksListMapper.insert(record);
    }

    @Override
    public int insertSelective(WorksList record) {
        return worksListMapper.insertSelective(record);
    }

    @Override
    public WorksList selectByPrimaryKey(Long id) {
        return worksListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WorksList record) {
        return worksListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WorksList record) {
        return worksListMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<WorksList> selectWorksList(WorksList record) {
        return worksListMapper.selectWorksList(record);
    }
}
