package com.jnshu.controller;


import com.jnshu.pojo.Studio;
import com.jnshu.service.StudioService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Controller
public class StudioController {
    private static final Logger logger = LogManager.getLogger(StudioController.class);

    @Autowired
    private StudioService studioService;

    @GetMapping("/studio")//查询studio
    @ResponseBody
    public Map<String,Object> selectstudio(Studio studio){
        logger.info("select studio is :" + studio);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Studio> list = studioService.selectStudio(studio);
            if(list.isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","不存在o");
            }else {
                resultMap.put("code", 200);
                resultMap.put("msg", "查询成功");
                resultMap.put("data", list);
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select studio error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/studio")//新增studio
    public Map<String,Object> insertstudio(Studio studio){
        logger.info("add studio is :" + studio);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            studio.setCreatat(time);
            studio.setUpdateby("管理员2");
            studio.setUpdateat(time);
            studioService.insert(studio);
            resultMap.put("code",200);
            resultMap.put("msg","添加studio成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add studio error");
        }
        return resultMap;
    }

    @DeleteMapping("/studio/{id}")//删除studio
    @ResponseBody
    public Map<String,Object> deletestudio(@PathVariable Long id){
        logger.info("delete studio's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Studio studio = new Studio();
        studio.setId(id);
        try {
            if(studioService.selectStudio(studio).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该studio不存在！");
            }else {
                studioService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete studio error");
        }
        return resultMap;
    }

    @PutMapping("/studio/{id}")//编辑studio
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Studio studio){
        logger.info("update studio's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Studio studio1 = new Studio();
        studio1.setId(id);
        try {
            if(studioService.selectStudio(studio1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该studio不存在");
            }else {
                studioService.updateByPrimaryKeySelective(studio);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update studio error");
        }
        return resultMap;
    }
}
