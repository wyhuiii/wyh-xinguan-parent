package com.wyh.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyh.response.Result;
import com.wyh.system.entity.User;
import com.wyh.system.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wyh
 * @since 2020-11-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /*
    * 分页查询用户列表
    * */
    @GetMapping("/findUserList")
    public Result findUserList(@RequestParam(required = true,defaultValue = "1")Integer current,
                               @RequestParam(required = true,defaultValue = "7")Integer size){
        //对用户进行分页，泛型中注入的就是用户实体类
        Page<User> page = new Page<>(current,size);
        Page<User> userPage = userService.page(page);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        return Result.ok().data("total",total).data("records",records);

    }

}

