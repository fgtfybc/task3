package com.jnshu.controller;

import com.jnshu.pojo.Leave;
import com.jnshu.service.LeaveService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LeaveController {

    private static final Logger logger = LogManager.getLogger(LeaveController.class);

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/Leave")//查询leave
    @ResponseBody
    public Map<String,Object> selectleave(Leave leave){
        logger.info("select leave is :" + leave);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Leave> list = leaveService.selectLeave(leave);
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
            logger.error("select leave error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/leave")//新增leave
    public Map<String,Object> insertleave(Leave leave){
        logger.info("add leave is :" + leave);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            leave.setCreatat(time);
            leave.setUpdateby("管理员2");
            leave.setUpdateat(time);
            leaveService.insert(leave);
            resultMap.put("code",200);
            resultMap.put("msg","添加leave成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add leave error");
        }
        return resultMap;
    }

    @DeleteMapping("/leave/{id}")//删除leave
    @ResponseBody
    public Map<String,Object> deleteleave(@PathVariable Long id){
        logger.info("delete leave's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Leave leave = new Leave();
        leave.setId(id);
        try {
            if(leaveService.selectLeave(leave).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该leave不存在！");
            }else {
                leaveService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete leave error");
        }
        return resultMap;
    }

    @PutMapping("/leave/{id}")//编辑leave
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Leave leave){
        logger.info("update leave's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Leave leave1 = new Leave();
        leave1.setId(id);
        try {
            if(leaveService.selectLeave(leave1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该leave不存在");
            }else {
                leaveService.updateByPrimaryKeySelective(leave);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update leave error");
        }
        return resultMap;
    }

}
