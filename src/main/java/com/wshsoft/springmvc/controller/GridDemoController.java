package com.wshsoft.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.wshsoft.mybatis.mapper.EntityWrapper;
import com.wshsoft.mybatis.plugins.Page;
import com.wshsoft.springmvc.common.annotations.Log;
import com.wshsoft.springmvc.common.model.dtgrid.Pager;
import com.wshsoft.springmvc.model.grid.User;
import com.wshsoft.springmvc.service.grid.IUserService;



@Controller
public class GridDemoController extends BaseController{
	

	@Autowired 
	IUserService iUserService;
	
	@RequestMapping("gridList")
	public String listUI(Model model, HttpServletRequest request) {
		
	  return "/grid/gridList";
	}
	
	/**
	 * ajax分页动态加载模式
	 * @param gridPager Pager对象
	 * @param request 请求对象
	 * @param response 响应对象
	 * @throws Exception
	 */
	@RequestMapping(value="/datas/ajax")
	@ResponseBody
	@Log("数据列表")
	public Object ajaxDatas(String gridPager, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String,Object> parameters = null;
		// 映射Pager对象
		Pager pager = JSON.parseObject(gridPager, Pager.class);
		// 判断是否包含自定义参数
		parameters = pager.getParameters();
		/*if (parameters.size() < 0) {
			parameters.put("name", null);
		}*/
        
		Page<User> page = new Page<User>(pager.getNowPage(), pager.getPageSize());
		
		EntityWrapper<User> ew = new EntityWrapper<User>(new User());
		page=iUserService.selectPage(page, ew);
		List<User> list=page.getRecords();
		parameters.clear();
		parameters.put("exhibitDatas", list);
		parameters.put("isSuccess", Boolean.TRUE);
		parameters.put("nowPage", pager.getNowPage());
		parameters.put("pageSize", pager.getPageSize());
		parameters.put("pageCount", page.getPages());
		parameters.put("recordCount", page.getTotal());
		return parameters;
	}
	
	
	@RequestMapping("/editUser")
	public String edit( Model model, Long id ) {
		if ( id != null ) {
			model.addAttribute("user", iUserService.selectById(id));
		}
		return "/grid/edit";
	}
	
	@RequestMapping("edit.html")
	@ResponseBody
	@Log("更新")
	public Object update(User user)
	{
		
        if (user.getUserId() == null) {
            return iUserService.insert(user) ? renderSuccess("添加成功") : renderError("添加失败");
        } else {
            return iUserService.updateById(user) ? renderSuccess("修改成功") : renderError("修改失败");
        }
	}
}
