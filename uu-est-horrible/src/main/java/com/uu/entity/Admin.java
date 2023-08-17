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
public class Admin {
    private Integer id;
    private String name;
    private Integer password;
    private String job;
    
    public Admin() {
    }

    public Admin(Integer id, String name, Integer password, String job) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.job = job;
    }
}
