package com.wyh.system.service.impl;

import com.wyh.system.entity.User;
import com.wyh.system.mapper.UserMapper;
import com.wyh.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wyh
 * @since 2020-11-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
