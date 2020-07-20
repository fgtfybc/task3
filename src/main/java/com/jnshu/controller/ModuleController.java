package com.jnshu.controller;

import com.jnshu.pojo.Module;
import com.jnshu.service.ModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ModuleController {
    private static final Logger logger = LogManager.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/module")//查询module
    @ResponseBody
    public Map<String,Object> selectModule(Module module){
        logger.info("select module is :" + module);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Module> list = moduleService.selectModule(module);
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
            logger.error("select module error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/module")//新增module
    public Map<String,Object> insertmodule(Module module){
        logger.info("add module is :" + module);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            module.setCreatat(time);
            module.setUpdateby("管理员2");
            module.setUpdateat(time);
            moduleService.insert(module);
            resultMap.put("code",200);
            resultMap.put("msg","添加module成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add module error");
        }
        return resultMap;
    }

    @DeleteMapping("/module/{id}")//删除module
    @ResponseBody
    public Map<String,Object> deletemodule(@PathVariable Long id){
        logger.info("delete module's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Module module = new Module();
        module.setId(id);
        try {
            if(moduleService.selectModule(module).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该module不存在！");
            }else {
                moduleService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete module error");
        }
        return resultMap;
    }

    @PutMapping("/module/{id}")//编辑module
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Module module){
        logger.info("update module's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Module module1 = new Module();
        module1.setId(id);
        try {
            if(moduleService.selectModule(module1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该module不存在");
            }else {
                moduleService.updateByPrimaryKeySelective(module);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update module error");
        }
        return resultMap;
    }


}
