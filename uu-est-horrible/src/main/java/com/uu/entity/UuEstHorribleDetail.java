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
public class UuEstHorribleDetail {
    private Integer detailId;
    private Integer number;
    private String hobby;
    private String memo;
    private Integer detailIdBk;
    private Integer numberBk;
    private String hobbyBk;
    private String memoBk;

    public UuEstHorribleDetail() {
    	
    }
    
    public UuEstHorribleDetail(Integer detailId, Integer number, String hobby, String memo) {
        this.detailId = detailId;
        this.number = number;
        this.hobby = hobby;
        this.memo = memo;
    }
}
