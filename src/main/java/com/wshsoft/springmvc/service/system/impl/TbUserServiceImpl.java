package com.wshsoft.springmvc.service.system.impl;

import org.springframework.stereotype.Service;

import com.wshsoft.springmvc.mapper.system.TbUserMapper;
import com.wshsoft.springmvc.model.system.TbUser;
import com.wshsoft.springmvc.service.system.ITbUserService;
import com.wshsoft.framework.service.impl.SuperServiceImpl;

/**
 *
 * TbUser 表数据服务层接口实现类
 *
 */
@Service
public class TbUserServiceImpl extends SuperServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

 
}