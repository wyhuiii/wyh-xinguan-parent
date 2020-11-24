package com.wyh.system.controller;


import com.wyh.handler.BusinessException;
import com.wyh.response.ResultCode;
import com.wyh.system.entity.TbUser;
import com.wyh.system.service.TbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wyh.response.Result;

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
@Api(value="系统用户模块",tags="系统用户接口")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;


    @GetMapping
    @ApiOperation(value = "用户列表",notes="查询所有用户信息")
    public Result findUsers(){
        //int i = 1/0;
        List<TbUser> list = tbUserService.list();
        return Result.ok().data("users",list);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询单个用户",notes="通过ID查询对应的用户信息")
    public Result getUserById(@PathVariable("id") Long id){
        TbUser user = tbUserService.getById(id);
        if(user!=null){
            return Result.ok().data("user",user);
        }else{
            throw new BusinessException(ResultCode.USER_NOT_FOUND_EXCEPTION.getCode(), ResultCode.USER_NOT_FOUND_EXCEPTION.getMessage());
        }

    }

}

