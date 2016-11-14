package com.wshsoft.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.wshsoft.mybatis.mapper.EntityWrapper;
import com.wshsoft.mybatis.plugins.pagination.Page;
import com.wshsoft.springmvc.common.model.dtgrid.Pager;
import com.wshsoft.springmvc.model.grid.User;
import com.wshsoft.springmvc.service.grid.IUserService;



@Controller
public class GridDemoController {
	

	@Autowired 
	IUserService iUserService;
	
	/**
	 * ajax分页动态加载模式
	 * @param gridPager Pager对象
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws Exception
	 */
	@RequestMapping(value="/datas/ajax", method=RequestMethod.POST)
	public void ajaxDatas(String gridPager, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> parameters = null;
		// 映射Pager对象
		Pager pager = JSON.parseObject(gridPager, Pager.class);
		// 判断是否包含自定义参数
		parameters = pager.getParameters();
		if (parameters.size() < 0) {
			parameters.put("name", null);
		}

		Page<User> page = new Page<User>(1, 10);
		EntityWrapper<User> ew = new EntityWrapper<User>(new User());
		page=iUserService.selectPage(page, ew);
		List<User> list=page.getRecords();
	}
}
