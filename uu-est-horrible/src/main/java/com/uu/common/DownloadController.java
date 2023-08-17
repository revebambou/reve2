package com.uu.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author uuEstHorrible
 *
 * @Description <p> 文件下载</p>
 */
@RequestMapping("file")
public class DownloadController extends BaseController {
	public DownloadController(String name) {
		super(name);
	}

	@Autowired
	BaseService service;
	
	@GetMapping("download")
    public ResponseEntity<byte[]> downlaodFile(HttpServletRequest request, @RequestParam("path") String path
            , @RequestHeader("user-agent") String userAgent, @RequestParam("filename") String filename
            ,@RequestParam(required = false,defaultValue = "false") boolean inline ) {
    	service.setLogger(logger);
    	return service.download(request, path, userAgent, filename, inline);
    }

}

