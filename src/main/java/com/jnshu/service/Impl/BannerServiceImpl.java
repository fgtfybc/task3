package com.jnshu.service.Impl;

import com.jnshu.dao.BannerMapper;
import com.jnshu.pojo.Banner;
import com.jnshu.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    public int deleteByPrimaryKey(Long id){
        return bannerMapper.deleteByPrimaryKey(id);
    }//删除banner

    public int insert(Banner record){
        return bannerMapper.insert(record);
    }//新增banner

    @Override
    public int insertSelective(Banner record) {
        return 0;
    }

    @Override
    public Banner selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Banner record){
        return bannerMapper.updateByPrimaryKeySelective(record);
    }//修改banner/上下架banner

    @Override
    public int updateByPrimaryKey(Banner record) {
        return 0;
    }

    public List<Banner> selectBanner(Banner record){
        return bannerMapper.selectBanner(record);
    }//查询banner
}
