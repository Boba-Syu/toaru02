package com.hunau.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

/**
 * Created by MI on 2019/2/1.
 * HTML页面跳转
 */
@Controller
public class Htmlcontroller {

    @RequestMapping(value = "/") // 将index.html设置为主界面
    public Callable<String> index(HttpSession session) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (session.getAttribute("userName") != null)
                    return "magic";
                return "index";
            }
        };
        return callable;
    }

    @RequestMapping(value = "login") // 跳转到登录界面login.html
    public Callable<String> login(HttpSession session) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                session.setAttribute("userName", null);
                return "login";
            }
        };
        return callable;
    }

    @RequestMapping(value = "register") // 跳转到注册界面register.html
    public Callable<String> register() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "register";
            }
        };
        return callable;
    }

    @RequestMapping(value = "/magic") // 跳转到科学侧的信息展示界面magic.html
    public Callable<String> show2(HttpSession session) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (session.getAttribute("userName") == null)
                    return "unlogin";
                return "magic";
            }
        };
        return callable;
    }

    @RequestMapping("/netty") // 跳转到信息广播界面entty.html
    public Callable<String> entty(HttpSession session) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (session.getAttribute("userName") == null)
                    return "unlogin";
                return "netty";
            }
        };
        return callable;
    }
}
