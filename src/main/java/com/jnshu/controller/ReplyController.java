package com.jnshu.controller;

import com.jnshu.pojo.Reply;

import com.jnshu.service.ReplyService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReplyController {

    private static final Logger logger = LogManager.getLogger(ReplyController.class);

    @Autowired
    private ReplyService replyService;

    @GetMapping("/reply")//查询reply
    @ResponseBody
    public Map<String,Object> selectreply(Reply reply){
        logger.info("select reply is :" + reply);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Reply> list = replyService.selectReply(reply);
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
            logger.error("select reply error");
        }
        return resultMap;
    }

    @ResponseBody
    @PostMapping("/reply")//新增reply
    public Map<String,Object> insertreply(Reply reply){
        logger.info("add reply is :" + reply);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            Long time = System.currentTimeMillis();
            reply.setCreateat(time);
            reply.setUpdateby("管理员2");
            reply.setUpdateat(time);
            replyService.insert(reply);
            resultMap.put("code",200);
            resultMap.put("msg","添加reply成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add reply error");
        }
        return resultMap;
    }

    @DeleteMapping("/reply/{id}")//删除reply
    @ResponseBody
    public Map<String,Object> deletereply(@PathVariable Long id){
        logger.info("delete reply's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Reply reply = new Reply();
        reply.setId(id);
        try {
            if(replyService.selectReply(reply).isEmpty()){
                resultMap.put("code", 404);
                resultMap.put("msg", "该reply不存在！");
            }else {
                replyService.deleteByPrimaryKey(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("delete reply error");
        }
        return resultMap;
    }

    @PutMapping("/reply/{id}")//编辑reply
    @ResponseBody
    public Map<String,Object> updateBanner(@PathVariable Long id,Reply reply){
        logger.info("update reply's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        Reply reply1 = new Reply();
        reply1.setId(id);
        try {
            if(replyService.selectReply(reply1).isEmpty()){
                resultMap.put("code",404);
                resultMap.put("msg","该reply不存在");
            }else {
                replyService.updateByPrimaryKeySelective(reply);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("update reply error");
        }
        return resultMap;
    }


}
