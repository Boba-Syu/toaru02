package com.hunau.controller;

import com.hunau.entity.Message;
import com.hunau.service.MessageService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by MI on 2019/3/4.
 * 信息公布系统页面(entity.html)的交互
 */
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/messageSelect")
    public Callable<List<Message>> select() { // 展示公布信息内容
        Callable<List<Message>> callable = new Callable<List<Message>>() {
            @Override
            public List<Message> call() throws Exception {
                List<Message> list = messageService.select();
                return list;
            }
        };
        return callable;
    }

    @RequestMapping("/messageInsert")
    public Callable<String> insert(@RequestParam(value = "ObjectMessage") String message) { // 公布信息信息输入到数据库中
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                JSONObject j = JSONObject.fromObject(message);
                Message message1 = (Message) JSONObject.toBean(j, Message.class);
                int result = messageService.insert(message1);
                if (result == 1) {
                    return "success";
                } else {
                    return "defeat";
                }
            }
        };
        return callable;
    }
}
