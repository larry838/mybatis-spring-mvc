package com.wshsoft.springmvc.service.grid.impl;

import org.springframework.stereotype.Service;

import com.wshsoft.mybatis.service.impl.ServiceImpl;
import com.wshsoft.springmvc.mapper.grid.UserMapper;
import com.wshsoft.springmvc.model.grid.User;
import com.wshsoft.springmvc.service.grid.IUserService;


/**
 *
 * TbUser 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}