package com.jnshu.controller;

import com.jnshu.pojo.Works;

import com.jnshu.service.WorksService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WorksController {
    private static final Logger logger = LogManager.getLogger(WorksController.class);

    @Autowired
    private WorksService worksService;

    @GetMapping("/works")//查询works
    @ResponseBody
    public Map<String,Object> selectworks(Works works){
        logger.info("select works is :" + works);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Works> list = worksService.selectWorks(works);
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
            logger.error("select works error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/works")//新增works
    public Map<String,Object> insertworks(Works works){
        logger.info("add works is :" + works);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            works.setCreatat(time);
            works.setUpdateby("管理员2");
            works.setUpdateat(time);
            worksService.insert(works);
            resultMap.put("code",200);
            resultMap.put("msg","添加works成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add works error");
        }
        return resultMap;
    }

    @DeleteMapping("/works/{id}")//删除works
    @ResponseBody
    public Map<String,Object> deleteworks(@PathVariable Long id){
        logger.info("delete works's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Works works = new Works();
        works.setId(id);
        try {
            if(worksService.selectWorks(works).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该works不存在！");
            }else {
                worksService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete works error");
        }
        return resultMap;
    }

    @PutMapping("/works/{id}")//编辑works
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Works works){
        logger.info("update works's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Works works1 = new Works();
        works1.setId(id);
        try {
            if(worksService.selectWorks(works1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该works不存在");
            }else {
                worksService.updateByPrimaryKeySelective(works);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update works error");
        }
        return resultMap;
    }
}
