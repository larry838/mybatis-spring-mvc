package com.wshsoft.springmvc.service.menu.impl;

import org.springframework.stereotype.Service;

import com.wshsoft.springmvc.mapper.menu.MenuMapper;
import com.wshsoft.springmvc.model.menu.Menu;
import com.wshsoft.springmvc.service.menu.IMenuService;
import com.wshsoft.framework.service.impl.ServiceImpl;

/**
 *
 * Menu 表数据服务层接口实现类
 *
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


}