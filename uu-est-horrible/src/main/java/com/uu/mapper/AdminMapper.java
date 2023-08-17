package com.uu.mapper;

import com.uu.entity.Admin;

/**
 * 
 * @author uuEstHorrible
 *
 */
public interface AdminMapper {
    //登录判断
    Admin login(Admin admin);
    //注册
    int addAdmin(Admin admin);
}
