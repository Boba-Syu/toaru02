package com.hunau.controller;

import com.hunau.entity.MagicUser;
import com.hunau.service.magicUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by MI on 2019/2/1.
 * 对stu_m表(magic界面信息展示用)的操作
 */
@RestController
public class MagicUserContror {
    @Autowired
    private magicUserService userService;

    @RequestMapping("/select")
    public Callable<MagicUser> select(@RequestParam(value = "ObjectUser") String user) { // 查找单行数据(暂时没用上)
        Callable<MagicUser> callable = new Callable<MagicUser>() {
            @Override
            public MagicUser call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                MagicUser user1 = (MagicUser) JSONObject.toBean(j, MagicUser.class);
                return userService.select(user1.getCname());
            }
        };
        return callable;
    }

    @RequestMapping("/search")
    public Callable<List<MagicUser>> search(@RequestParam(value = "ObjectUser") String user) { // 查找相匹配的数据(搜索用)
        Callable<List<MagicUser>> callable = new Callable<List<MagicUser>>() {
            @Override
            public List<MagicUser> call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                MagicUser user1 = (MagicUser) JSONObject.toBean(j, MagicUser.class);
                return userService.search(user1.getCname());
            }
        };
        return callable;
    }

    @RequestMapping("/insert")
    public Callable<String> insert(@RequestParam(value = "ObjectUser") String user) { // 插入数据
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                MagicUser user1 = (MagicUser) JSONObject.toBean(j, MagicUser.class);
                int result = userService.insert(user1);
                if (result == 1) {
                    return "success";
                } else {
                    return "defeat";
                }
            }
        };
        return callable;
    }

    @RequestMapping("/update")
    public Callable<String> update(@RequestParam(value = "ObjectUser") MagicUser user) { // 更新某行数据
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                int result = userService.update(user);
                if (result == 1) {
                    return "success";
                } else {
                    return "defeat";
                }
            }
        };
        return callable;
    }

    @RequestMapping("/delete")
    public Callable<String> delete(@RequestParam(value = "ObjectUser") String user) { //删除某行数据
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                JSONObject j = JSONObject.fromObject(user);
                MagicUser user1 = (MagicUser) JSONObject.toBean(j, MagicUser.class);
                int result = userService.delete(user1.getCname());
                if (result == 1) {
                    return "success";
                } else {
                    return "defeat";
                }
            }
        };
        return callable;
    }

    @RequestMapping("/show2")
    public Callable<List<MagicUser>> show() {
        Callable<List<MagicUser>> callable = new Callable<List<MagicUser>>() { // 查询表中所有数据(刷新用)
            @Override
            public List<MagicUser> call() throws Exception {
                List<MagicUser> users = userService.showAll();
                return users;
            }
        };
        return callable;
    }
}
