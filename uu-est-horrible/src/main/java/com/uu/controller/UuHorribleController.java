package com.uu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uu.entity.Admin;
import com.uu.entity.UserInfo;
import com.uu.mapper.AdminMapper;
import com.uu.mapper.UserInfoMapper;

/**
 * 
 * @author uuEstHorrible
 *
 */
@Controller
public class UuHorribleController {
	/**
	* @param path     指想要下载的文件的路径
	* @param response
	* @功能描述 下载文件:将输入流中的数据循环写入到响应输出流中，而不是一次性读取到内存
	*/
	@RequestMapping("/downloadLocal")
	public void downloadLocal(String path, HttpServletResponse response) throws IOException {
		String localPath = "D:\\Develop\\log\\";
		path = localPath + path;
	   // 读到流中
	   InputStream inputStream = new FileInputStream(path);// 文件的存放路径
	   response.reset();
	   response.setContentType("application/octet-stream");
	   String filename = new File(path).getName();
	   response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
	   ServletOutputStream outputStream = response.getOutputStream();
	   byte[] b = new byte[1024];
	   int len;
	   //从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
	   while ((len = inputStream.read(b)) > 0) {
	       outputStream.write(b, 0, len);
	   }
	   inputStream.close();
	} 
}
