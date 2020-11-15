package com.wyh.system.controller;


import com.wyh.system.entity.TbUser;
import com.wyh.system.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wyh
 * @since 2020-11-14
 */
@RestController
@RequestMapping("/system/tb-user")
@Api(value="用户管理")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;


    @GetMapping
    @ApiOperation(value = "查询")
    public List<TbUser> findUsers(){
        List<TbUser> list = tbUserService.list();
        return list;
    }

}

