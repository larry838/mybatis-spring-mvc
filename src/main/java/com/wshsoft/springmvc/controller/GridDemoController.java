package com.wshsoft.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




public class GridDemoController {

	/**
	 * ajax分页动态加载模式
	 * @param gridPager Pager对象
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws Exception
	 */
	@RequestMapping(value="/datas/ajax", method=RequestMethod.POST)
	public void ajaxDatas(String gridPager, HttpServletRequest request, HttpServletResponse response) throws Exception {

	}
}
