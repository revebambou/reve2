package com.uu.common;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Service
public class EntityService {
	@Getter
	@Setter
    protected EntityMapper mapper;
	
	@Getter
	@Setter
    protected Model model;
    
	/**
     * refer
     * @return
     */
	public Object refer(Object obj) {
		return mapper.refer(obj);
	}
 
	/**
	 * insert
	 * @return
	 */
    public Object insert() {
    	return mapper.insert();
    }
 
    /**
     * update
     * @return
     */
    public Object update() {
    	return mapper.update();
    }
 
    /**
     * delete
     * @return
     */
    public Object delete() {
    	return mapper.delete();
    }
}
