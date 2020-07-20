package com.jnshu.controller;


import com.jnshu.pojo.Role;

import com.jnshu.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    private static final Logger logger = LogManager.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")//查询role
    @ResponseBody
    public Map<String,Object> selectrole(Role role){
        logger.info("select role is :" + role);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Role> list = roleService.selectRole(role);
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
            logger.error("select role error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/role")//新增role
    public Map<String,Object> insertrole(Role role){
        logger.info("add role is :" + role);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            role.setCreatat(time);
            role.setUpdateby("管理员2");
            role.setUpdateat(time);
            roleService.insert(role);
            resultMap.put("code",200);
            resultMap.put("msg","添加role成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add role error");
        }
        return resultMap;
    }

    @DeleteMapping("/role/{id}")//删除role
    @ResponseBody
    public Map<String,Object> deleterole(@PathVariable Long id){
        logger.info("delete role's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Role role = new Role();
        role.setId(id);
        try {
            if(roleService.selectRole(role).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该role不存在！");
            }else {
                roleService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete role error");
        }
        return resultMap;
    }

    @PutMapping("/role/{id}")//编辑role
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Role role){
        logger.info("update role's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Role role1 = new Role();
        role1.setId(id);
        try {
            if(roleService.selectRole(role1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该role不存在");
            }else {
                roleService.updateByPrimaryKeySelective(role);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update role error");
        }
        return resultMap;
    }
}
