package com.uu.controller;

import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uu.common.Constant;
import com.uu.entity.UuEstHorrible;
import com.uu.entity.UuEstHorribleDetail;
import com.uu.entity.UuEstHorribleEditDetail;
import com.uu.mapper.UserInfoMapper;
import com.uu.mapper.UuEstHorribleMapper;

/**
 * 
 * @author UuEstHorrible
 *
 */
@Controller
//把这个bean 的范围设置成session，表示这bean是会话级别的，
@Scope("session")
public class UuEstHorribleController {
    @Resource
    private UuEstHorribleMapper UuEstHorribleMapper;
    @Resource
    private UserInfoMapper ud;
    
    private int increaseNumber = 0;
    private long startTimeMillis;
    private long endTimeMillis;
    private int queryMaxValueCnt = 0;
    
    //@PostConstruct当bean加载完之后，就会执行init方法:
    @PostConstruct
    public void init(){
    	increaseNumber = 0;
    	queryMaxValueCnt = 0;
    } 

    @RequestMapping("/" + Constant.FORWARD_UU_HORRIBLE) //主页
    public String index(Model model) {
    	int id = 1;
    	UuEstHorrible UuEstHorrible = UuEstHorribleMapper.queryUuEstHorribleById(id);
    	List<UuEstHorribleDetail> UuEstHorribleDetail = UuEstHorribleMapper.queryUuEstHorribleDetailById(id);
    	List<UuEstHorribleEditDetail> UuEstHorribleEditDetail = UuEstHorribleMapper.queryUuEstHorribleEditDetailById(id);
    	UuEstHorrible.setUuEstHorribleDetailList(UuEstHorribleDetail);
    	UuEstHorrible.setUuEstHorribleEditDetailList(UuEstHorribleEditDetail);
    	model.addAttribute(Constant.ATTRIBUTE_UU_HORRIBLE, UuEstHorrible);
    	model.addAttribute(Constant.CONSTANT_ACTION, Constant.FORWARD_UU_HORRIBLE + "Update");
    	setUuEstHorrible(UuEstHorrible);
    	for (UuEstHorribleDetail uuEstHorribleDetail: UuEstHorribleDetail) {
    		setUuEstHorrible(uuEstHorribleDetail);
    	}
    	if (null != UuEstHorribleEditDetail) {
    		for (UuEstHorribleEditDetail uuEstHorribleEditDetail: UuEstHorribleEditDetail) {
        		setUuEstHorrible(uuEstHorribleEditDetail);
        	}
    	}
    	
        return Constant.FORWARD_UU_HORRIBLE;
    }
    

    @RequestMapping("/" + Constant.FORWARD_UU_HORRIBLE + "Update") //主页
    public String update(Model model, HttpServletRequest request, UuEstHorrible UuEstHorribleParam) {
    	startTimeMillis = System.currentTimeMillis();
    	increaseNumber = 0;
    	queryMaxValueCnt = 0;
    	
    	compareUuEstHorrible(UuEstHorribleParam);
    	for (UuEstHorribleDetail UuEstHorribleDetail: UuEstHorribleParam.getUuEstHorribleDetailList()) {
    		compareUuEstHorrible(UuEstHorribleDetail);
    	}
    	
    	int id = 1;
    	UuEstHorrible UuEstHorrible = UuEstHorribleMapper.queryUuEstHorribleById(id);
    	List<UuEstHorribleDetail> UuEstHorribleDetail = UuEstHorribleMapper.queryUuEstHorribleDetailById(id);
    	List<UuEstHorribleEditDetail> UuEstHorribleEditDetail = UuEstHorribleMapper.queryUuEstHorribleEditDetailById(id);
    	UuEstHorrible.setUuEstHorribleDetailList(UuEstHorribleDetail);
    	UuEstHorrible.setUuEstHorribleEditDetailList(UuEstHorribleEditDetail);
    	model.addAttribute(Constant.ATTRIBUTE_UU_HORRIBLE, UuEstHorrible);
    	model.addAttribute(Constant.CONSTANT_ACTION, Constant.FORWARD_UU_HORRIBLE + "Update");
    	setUuEstHorrible(UuEstHorrible);
    	for (UuEstHorribleDetail uuEstHorribleDetail: UuEstHorribleDetail) {
    		setUuEstHorrible(uuEstHorribleDetail);
    	}
    	if (null != UuEstHorribleEditDetail) {
    		for (UuEstHorribleEditDetail uuEstHorribleEditDetail: UuEstHorribleEditDetail) {
        		setUuEstHorrible(uuEstHorribleEditDetail);
        	}
    	}
    	
    	endTimeMillis = System.currentTimeMillis();
    	System.out.println(endTimeMillis - startTimeMillis);
    	return Constant.FORWARD_UU_HORRIBLE;
    }
    
    private void setUuEstHorrible(Object obj) {
    	Class<? extends Object> cls = obj.getClass();
    	Method[] methods = cls.getDeclaredMethods();
    	for (Method method: methods) {
    		String methodName = method.getName();
    		if (methodName.startsWith(Constant.SET_METHOD_PREFIX) && methodName.endsWith("Bk")) {
    			methodName = methodName.substring(3, methodName.length() - 2);
    			try {
					method.invoke(obj, cls.getMethod(Constant.GET_METHOD_PREFIX + methodName).invoke(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    }
    
    private void compareUuEstHorrible(Object obj) {
    	UuEstHorrible UuEstHorrible = null;
    	UuEstHorribleEditDetail editDetail = new UuEstHorribleEditDetail();
    	UuEstHorribleDetail detail = null;
    	Integer id = null;
    	Integer number = null;
    	if (obj instanceof UuEstHorrible) {
    		UuEstHorrible = (UuEstHorrible) obj;
    		id = UuEstHorrible.getId();
    	} else if (obj instanceof UuEstHorribleDetail) {
			detail = (UuEstHorribleDetail) obj;
			id = detail.getDetailId();
			number = detail.getNumber();
		}
    	
    	Class<? extends Object> cls = obj.getClass();
    	Method[] methods = cls.getDeclaredMethods();
    	String beforeEdit = null;
    	String afterEdit = null;
    	Object object = null;
    	Object object2 = null;
    	int editTimes = 0;
    	boolean queryMaxFlg = true;
    	for (Method method: methods) {
    		String methodName = method.getName();
    		if (methodName.startsWith(Constant.GET_METHOD_PREFIX) && methodName.endsWith("Bk")) {
    			methodName = methodName.substring(0, methodName.length() - 2);
    			try {
    				object = method.invoke(obj);
    				object2 = cls.getMethod(methodName).invoke(obj);
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			
    			if (object instanceof String) {
					beforeEdit = (String) object;
					afterEdit = (String) object2;
				} else if (object instanceof Integer) {
					beforeEdit = String.valueOf((Integer) object);
					afterEdit = String.valueOf((Integer) object2);
				}
				
				// the value is changed
				if (!beforeEdit.equals(afterEdit)) {
					editDetail.reset();
					editDetail.setEditDetailId(id);
					editDetail.setEditPlace(methodName);
					editDetail.setBeforeEdit(beforeEdit);
					editDetail.setAfterEdit(afterEdit);
					editDetail.setNumber(number);
					
					// query for the 1st time
					if (queryMaxValueCnt == 0) {
						editDetail.setNumber(-1);
						UuEstHorribleEditDetail UuEstHorribleEditDetailMax = UuEstHorribleMapper.queryUuEstHorribleEditDetailMaxValue(editDetail);
						if (null != UuEstHorribleEditDetailMax) {
							increaseNumber = UuEstHorribleEditDetailMax.getIncreaseNumber();
						}
						
						editDetail.setNumber(number);
						queryMaxValueCnt++;
					} else {
						increaseNumber++;
					}
					if (queryMaxFlg) {
						UuEstHorribleEditDetail UuEstHorribleEditDetailMax = UuEstHorribleMapper.queryUuEstHorribleEditDetailMaxValue(editDetail);
						if (null != UuEstHorribleEditDetailMax) {
							editTimes = UuEstHorribleEditDetailMax.getEditTimes();
						}
						
						queryMaxFlg = false;
					} else {
						editTimes++;
					}
					
					editDetail.setIncreaseNumber(increaseNumber);
					editDetail.setEditTimes(editTimes);
					UuEstHorribleMapper.insertUuEstHorribleEditDetail(editDetail);
				}
    		}
    	}
    }
}
