package com.uu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uu.common.EntityController;
import com.uu.mapper.UserInfoMapper;
import com.uu.service.UuUserService;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Controller
@RequestMapping("/uuUser")
public class UuUserController extends EntityController {
    @Autowired
    UuUserService service;
	@Autowired
	UserInfoMapper uuUserMapper;
    
	/**
     * refer
     * @return
     */
    @RequestMapping("register")
    public String register(Model model) {
        System.out.println("register函数已经运行！！");
        return "uuLogin";//使用了重定向进行返回到index.html
    }
    
    /**
     * refer
     * @return
     */
    @RequestMapping("refer")
    public String refer(Model model) {
    	service.setMapper(uuUserMapper);
    	service.setModel(model);
    	return (String) service.refer(1);
    }
 
	/**
	 * insert
	 * @return
	 */
    @RequestMapping("insert")
    public String insert(Model model) {
    	return (String) service.insert();
    }
 
    /**
     * update
     * @return
     */
    @RequestMapping("update")
    public String update(Model model) {
    	return (String) service.update();
    }
 
    /**
     * delete
     * @return
     */
    @RequestMapping("delete")
    public String delete(Model model) {
    	return (String) service.delete();
    }
}
