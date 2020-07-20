package com.jnshu.service;

import com.jnshu.pojo.Reply;

import java.util.List;

public interface ReplyService {

    int deleteByPrimaryKey(Long id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> selectReply(Reply record);
}
