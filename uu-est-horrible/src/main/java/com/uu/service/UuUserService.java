package com.uu.service;
 
import com.uu.common.EntityService;
import com.uu.entity.UserInfo;

import org.springframework.stereotype.Service;
 
/**
 * 
 * @author uuEstHorrible
 *
 */
@Service
public class UuUserService extends EntityService {

	/**
     * refer
     * @return
     */
	public Object refer(Object obj) {
		UserInfo user = (UserInfo) mapper.refer(1);
		model.addAttribute("uuUser", user);
		model.addAttribute("name", user.getName());
		
		return "uuUser";
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