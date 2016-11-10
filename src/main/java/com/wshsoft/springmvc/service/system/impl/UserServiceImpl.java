package com.wshsoft.springmvc.service.system.impl;

import org.springframework.stereotype.Service;

import com.wshsoft.springmvc.mapper.system.UserMapper;
import com.wshsoft.springmvc.model.system.User;
import com.wshsoft.springmvc.service.system.IUserService;
import com.wshsoft.framework.service.impl.SuperServiceImpl;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements IUserService {

 
}