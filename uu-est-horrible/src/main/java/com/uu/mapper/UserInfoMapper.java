package com.uu.mapper;

import java.util.List;

import com.uu.common.EntityMapper;
/**
 * 
 * @author uuEstHorrible
 *
 */
import com.uu.entity.UserInfo;

public interface UserInfoMapper extends EntityMapper {
    //查
    List<UserInfo> findall();
    //增
    int adduser(UserInfo user);
    //根据Id查，用于修改时页面回显数据
    UserInfo findByid(Integer id);
    //修改
    int updateUser(UserInfo user);
    //删除
    int delUser(Integer id);
}
