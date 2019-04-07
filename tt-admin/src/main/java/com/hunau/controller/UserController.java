package com.hunau.controller;

import com.hunau.entity.User;
import com.hunau.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

/**
 * Created by MI on 2019/2/7.
 * 对stu_user表(用户登录/注册用)进行操作
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("userLogin")
    public Callable<String> userLogin(@RequestParam(value = "ObjectUser") String user, HttpSession session) { // 查找单行数据(登录用)
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                User user1 = (User) JSONObject.toBean(j, User.class);
                User user2 = userService.login(user1);
                if(user2.getPwd().equals(user1.getPwd())) {
                    session.setAttribute("userName", user1.getName());
                    return "success";
                } else
                    return "defeat";
            }
        };
        return callable;
    }

    @RequestMapping(value = "userRegister")
    public Callable<String> userRegister(@RequestParam(value = "ObjectUser") String user) { // 插入数据(注册用)
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                User user1 = (User) JSONObject.toBean(j, User.class);
                int result = userService.register(user1);
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
