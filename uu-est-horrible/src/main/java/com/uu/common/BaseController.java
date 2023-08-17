package com.uu.common;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Setter
@Getter
public class BaseController {
    /**
     * logger
     */
	protected Logger logger;
	
	public BaseController(String name) {
		logger = LoggerFactory.getLogger(name);
	}
}
