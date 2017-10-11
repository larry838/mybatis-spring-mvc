package com.wshsoft.springmvc.controller;

import com.wshsoft.mybatis.mapper.EntityWrapper;
import com.wshsoft.springmvc.common.annotations.Log;
import com.wshsoft.springmvc.model.system.TbUser;
import com.wshsoft.springmvc.service.system.ITbUserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: carry xie
 * Email: larry838@126.com
 * Date: 16/10/9
 * Time: 上午11:58
 * Describe: 用户控制器
 */
@Controller
public class TbUserController extends BaseController {
	@Autowired
    private  ITbUserService iTbUserService;



    @RequestMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("userList", iTbUserService.selectList(null));
        return modelAndView;

    }

    @RequestMapping("/preSave")
    @Log("保存")
    public ModelAndView preSave(ModelAndView modelAndView, @RequestParam(value = "id", required = false) Long id) {
        modelAndView.setViewName("save");
        if (id != null) {
            modelAndView.addObject("user", iTbUserService.selectById(id));
        }
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("save")
    public Object save(TbUser user) {
        if (user.getId() == null) {
            return iTbUserService.insert(user) ? renderSuccess("添加成功") : renderError("添加失败");
        } else {
            return iTbUserService.updateById(user) ? renderSuccess("修改成功") : renderError("修改失败");
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    @Log("删除")
    public Object delete(@RequestParam(value = "id", required = false) Long id) {
        return iTbUserService.deleteById(id) ? renderSuccess("删除成功") : renderError("删除失败");
    }
    
	@RequestMapping(value = "/getUsers",method = RequestMethod.GET)
	@ResponseBody
	public List<TbUser> getUsers(){
		List<TbUser> userVos=new ArrayList<>();
		for (int i=1;i<=10;i++){
			TbUser userVo=new TbUser();
			userVo.setId(2017072012504723359L+i);
			userVo.setName("测试用户"+i);
			userVo.setBirthday(new Date());
			userVos.add(userVo);
		}
		return userVos;
	}
    
}
