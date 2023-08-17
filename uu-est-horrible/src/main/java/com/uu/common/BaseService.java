package com.uu.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author uuEstHorrible
 *
 */
public class BaseService {
    @Autowired
    EntityMapper mapper;
    /**
     * logger
     */
    @Setter
    @Getter
	protected Logger logger;
    
    public ResponseEntity<byte[]> download(HttpServletRequest request, String path
            , String userAgent, String filename, boolean inline ) {
    	return null;
    }
}
