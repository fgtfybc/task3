package com.jnshu.service.Impl;

import com.jnshu.dao.LeaveMapper;
import com.jnshu.pojo.Leave;
import com.jnshu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return leaveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Leave record) {
        return leaveMapper.insert(record);
    }

    @Override
    public int insertSelective(Leave record) {
        return leaveMapper.insertSelective(record);
    }

    @Override
    public Leave selectByPrimaryKey(Long id) {
        return leaveMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Leave record) {
        return leaveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Leave record) {
        return leaveMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Leave record) {
        return leaveMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Leave> selectLeave(Leave record) {
        return leaveMapper.selectLeave(record);
    }
}
