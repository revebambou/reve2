package com.uu.common;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author uuEstHorrible
 *
 * @Description <p> 文件下载</p>
 * @Description <p> download file</p>
 */
@Controller
public class UploadController {
	private final String forwardPath = "ouestUpload";
	
    @GetMapping(value = "/fileUpload")
    public String file() {
        return forwardPath;
    }

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model,
    		HttpServletRequest request, @RequestParam("fileUploadPath") String fileUploadPath) {
        if (file.isEmpty()) {
            return forwardPath;
        }

        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        String filePath = Constant.CONSTANT_DISK_NAME + ":" + fileUploadPath;
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
 
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename = fileUploadPath + fileName;
        model.addAttribute("filename", filename);

        return forwardPath;
    }
}

