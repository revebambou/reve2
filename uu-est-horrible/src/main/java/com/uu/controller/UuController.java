package com.uu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uu.entity.Admin;
import com.uu.entity.UserInfo;
import com.uu.mapper.AdminMapper;
import com.uu.mapper.UserInfoMapper;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Controller
public class UuController {
    @Resource
    private AdminMapper ad;
    @Resource
    private UserInfoMapper ud;

    @RequestMapping("/login")//主页
    public String index(){
        return "login";
    }

    @RequestMapping("/goregister")//去注册页面
    public String goregister(){
        return  "register";
    }
    @RequestMapping("/register")//注册
    @ResponseBody
    public boolean register(Admin admin){
        int i = ad.addAdmin(admin);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/gologin")//登录获取用户信息存到seccion
    public String  gologin(Admin admin,HttpServletRequest request,Model model){
        Admin aa = ad.login(admin);
        if (aa==null){
            return  "public/false";
        }
        HttpSession session =  request.getSession();
        session.setAttribute("aname",admin.getName());
        session.setAttribute("apassword",admin.getPassword());
        List<UserInfo> userlist = ud.findall();
        model.addAttribute("admin",aa);
        model.addAttribute("alist",userlist);
        return "user/index";
    }

    @RequestMapping("/index")//从其他页面操作后返回列表页面（重复登录）
    public String login(Admin admin,Model model,HttpServletRequest request){
        HttpSession session =  request.getSession();
        admin.setName((String) session.getAttribute("aname"));
        admin.setPassword((Integer) session.getAttribute("apassword"));
        Admin aa = ad.login(admin);
        List<UserInfo> userlist = ud.findall();
        model.addAttribute("admin",aa);
        model.addAttribute("alist",userlist);
        return "user/index";
    }
    
    @RequestMapping("/goadd")//去添加页面
    public String goadd(){
        return "user/addUser";
    }
    @RequestMapping("/addUser")//添加信息
    @ResponseBody
    public boolean addUser(UserInfo user){
        int i = ud.adduser(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/goupdate/{id}")//去修改页面，回显数据
    public String goupdate(@PathVariable("id") int id,Model model){
        UserInfo user = ud.findByid(id);
        model.addAttribute("user",user);
        return "user/updateUser";
    }
    @RequestMapping("/update")//修改
    @ResponseBody
    public boolean updateUser(UserInfo user){
        int i = ud.updateUser(user);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/godel/{id}")//删除
    public String delUser(@PathVariable("id") Integer id){
       ud.delUser(id);
       return "public/success";
    }
}
