package com.uu.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Controller
@RequestMapping("/controller")
public class EntityController {
    protected EntityService service;
    
	/**
     * refer
     * @return
     */
	public String refer(Model model) {
		return (String) service.refer(new Object());
	}
 
	/**
	 * insert
	 * @return
	 */
    public String insert(Model model) {
    	return (String) service.insert();
    }
 
    /**
     * update
     * @return
     */
    public String update(Model model) {
    	return (String) service.update();
    }
 
    /**
     * delete
     * @return
     */
    public String delete(Model model) {
    	return (String) service.delete();
    }
}
