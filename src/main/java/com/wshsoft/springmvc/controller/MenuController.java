package com.wshsoft.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wshsoft.springmvc.service.menu.IMenuService;

/**
 * Author: carry xie
 * Email: larry838@126.com
 * Date: 16/10/9
 * Time: 上午11:58
 * Describe: 菜单控制器
 */
@Controller
public class MenuController {
	
	@Autowired 
	IMenuService iMenuService;
	
	
	
    @RequestMapping("/menu")
    public ModelAndView getResourceList(ModelAndView modelAndView) {
        modelAndView.setViewName("menuList");
        modelAndView.addObject("menulist", iMenuService.selectList(null));
        return modelAndView;
    }

}
