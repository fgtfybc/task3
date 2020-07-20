package com.jnshu.controller;

import com.jnshu.pojo.Banner;
import com.jnshu.service.BannerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BannerController {
    private static final Logger logger = LogManager.getLogger(BannerController.class);

    @Autowired
    private BannerService bannerService;

    @GetMapping("/Banner")//查询banner
    @ResponseBody
    public Map<String,Object> selectBanner(Banner banner){
        logger.info("select banner is :" + banner);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Banner> list = bannerService.selectBanner(banner);
            if(list.isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","无");
            }else {
                resultMap.put("code", 200);
                resultMap.put("msg", "查询成功");
                resultMap.put("data", list);
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select banner error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/Banner")//新增banner
    public Map<String,Object> insertBanner(Banner banner){
        logger.info("add banner is :" + banner);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            banner.setCreatby("管理员1");
            banner.setCreatat(time);
            banner.setUpdateby("管理员1");
            banner.setUpdateat(time);
            bannerService.insert(banner);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add banner error");
        }
        return resultMap;
    }

    @DeleteMapping("/Banner/{id}")//删除banner
    @ResponseBody
    public Map<String,Object> deleteBanner(@PathVariable Long id){
        logger.info("delete Banner's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Banner banner = new Banner();
        banner.setId(id);
        try {
            if(bannerService.selectBanner(banner).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该banner不存在！");
            }else {
                bannerService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete banner error");
        }
        return resultMap;
    }

    @PutMapping("/Banner/{id}")//编辑banner
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Banner banner){
        logger.info("update banner's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Banner banner1 = new Banner();
        banner1.setId(id);
        try {
            if(bannerService.selectBanner(banner1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该banner不存在");
            }else {
                bannerService.updateByPrimaryKeySelective(banner);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update banner error");
        }
        return resultMap;
    }
}
