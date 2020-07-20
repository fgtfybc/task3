package com.jnshu.service;

import com.jnshu.pojo.Banner;

import java.util.List;

public interface BannerService {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);

    List<Banner> selectBanner(Banner record);//按条件查询banner

}
