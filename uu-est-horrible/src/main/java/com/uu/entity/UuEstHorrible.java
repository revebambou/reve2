package com.uu.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Getter
@Setter
public class UuEstHorrible implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String memo;
    private List<UuEstHorribleDetail> uuEstHorribleDetailList;
    private List<UuEstHorribleEditDetail> uuEstHorribleEditDetailList;
    private Integer idBk;
    private String nameBk;
    private Integer ageBk;
    private String memoBk;
    
    public UuEstHorrible() {
    }

    public UuEstHorrible(Integer id, String name, Integer age, String memo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.memo = memo;
    }
}
