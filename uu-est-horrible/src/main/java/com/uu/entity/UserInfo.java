package com.uu.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Getter
@Setter
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    public UserInfo() {
    }
    public UserInfo(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
