package com.jnshu.controller;


import com.jnshu.pojo.WorksList;
import com.jnshu.service.WorksListService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Controller
public class WorksListController {
    private static final Logger logger = LogManager.getLogger(WorksListController.class);

    @Autowired
    private WorksListService worksListService;

    @GetMapping("/worksList")//查询worksList
    @ResponseBody
    public Map<String,Object> selectworksList(WorksList worksList){
        logger.info("select worksList is :" + worksList);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<WorksList> list = worksListService.selectWorksList(worksList);
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
            logger.error("select worksList error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/worksList")//新增worksList
    public Map<String,Object> insertworksList(WorksList worksList){
        logger.info("add worksList is :" + worksList);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            worksList.setCreateat(time);
            worksList.setUpdateby("管理员2");
            worksList.setUpdateat(time);
            worksListService.insert(worksList);
            resultMap.put("code",200);
            resultMap.put("msg","添加worksList成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add worksList error");
        }
        return resultMap;
    }

    @DeleteMapping("/worksList/{id}")//删除worksList
    @ResponseBody
    public Map<String,Object> deleteworksList(@PathVariable Long id){
        logger.info("delete worksList's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        WorksList worksList = new WorksList();
        worksList.setId(id);
        try {
            if(worksListService.selectWorksList(worksList).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该worksList不存在！");
            }else {
                worksListService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete worksList error");
        }
        return resultMap;
    }

    @PutMapping("/worksList/{id}")//编辑worksList
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,WorksList worksList){
        logger.info("update worksList's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        WorksList worksList1 = new WorksList();
        worksList1.setId(id);
        try {
            if(worksListService.selectWorksList(worksList1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该worksList不存在");
            }else {
                worksListService.updateByPrimaryKeySelective(worksList);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update worksList error");
        }
        return resultMap;
    }
}
