package com.company.sbasic007;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadBasicController {
	@RequestMapping(value="basic/upload", method=RequestMethod.GET)
	public String uploadGet() {return "uploadForm";}
	
	@RequestMapping(value="basic/upload", method=RequestMethod.POST)
	public String uploadPost(MultipartFile file, HttpServletRequest request,  Model model) {
		log.info("name은!!!!! + " + file.getOriginalFilename());
		log.info("size은!!!!! + " + file.getSize());
		log.info("contextType은!!!!! + " + file.getContentType());
		// 1. 파일이름 중복되지 않게 고유한 키 값 설정
		String saveName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		// 2. 파일업로드
		String path = "/upload"; //C://upload
		path="C:\\upload";
		
		File target = new File(path, saveName);	// File (파일경로, 파일이름)
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // 실제파일처리는 스프링에서 제공되는 FileCopyUtils 이용
		model.addAttribute("saveName", saveName);
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("title", request.getParameter("title"));
		return "uploadResult";}
}
