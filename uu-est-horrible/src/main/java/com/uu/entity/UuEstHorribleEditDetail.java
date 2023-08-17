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
public class UuEstHorribleEditDetail {
	private Integer editDetailId;
    private Integer increaseNumber;
    private Integer editTimes;
    private Integer number;
    private String editPlace;
    private String beforeEdit;
    private String afterEdit;
    private String memo;
    private Integer editDetailIdBk;
    private Integer increaseNumberBk;
    private Integer editTimesBk;
    private Integer numberBk;
    private String editPlaceBk;
    private String beforeEditBk;
    private String afterEditBk;
    private String memoBk;

    public UuEstHorribleEditDetail() {
    	
    }
    
    public UuEstHorribleEditDetail(Integer editDetailId, Integer increaseNumber, Integer editTimes, Integer number,
    		String editPlace, String beforeEdit, String afterEdit, String memo) {
        this.editDetailId = editDetailId;
        this.increaseNumber = increaseNumber;
        this.editTimes = editTimes;
        this.number = number;
        this.editPlace = editPlace;
        this.beforeEdit = beforeEdit;
        this.afterEdit = afterEdit;
        this.memo = memo;
    }
    
    public void reset() {
    	editDetailId = null;
        increaseNumber = null;
        editTimes = null;
        number = null;
        editPlace = null;
        beforeEdit = null;
        afterEdit = null;
        memo = null;
        editDetailIdBk = null;
        increaseNumberBk = null;
        editTimesBk = null;
        numberBk = null;
        editPlaceBk = null;
        beforeEditBk = null;
        afterEditBk = null;
        memoBk = null;
    }
}
