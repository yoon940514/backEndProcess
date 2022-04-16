package com.company.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.dto.BoardDto;
import com.company.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	@Autowired
	BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list_get (Model model) 
	{
		log.info("........list");
		model.addAttribute("list", service.list());
	}
	
	// 글쓰기폼
	@RequestMapping(value = "/write", method = RequestMethod.GET) 
	public void create_get()
	{
		log.info("........create_view");
	}
	
	// 글쓰기
	@RequestMapping(value = "/write_post", method = RequestMethod.POST) 
	public String create_post (BoardDto dto, MultipartFile file, HttpServletRequest request, RedirectAttributes rttr)
    {
		log.info("........create_write");
		log.info(";;;;;;;;;;;;;;;;;;;;;;;dto테스트" + dto);
		
		String result = "fail";
		if (service.create(dto, file, request) > 0)
		{
			result = "글쓰기성공";
			rttr.addFlashAttribute("result", result);
		}
		return "redirect:/board/list"; 
	}

	// 상세보기
	@RequestMapping(value = "/detail", method = RequestMethod.GET) 
	public void select_get (BoardDto dto, Model model)
    {   
		model.addAttribute("dto", service.read(dto));
    }
 
	// 수정하기 폼
    @RequestMapping(value = "/edit", method = RequestMethod.GET) 
    public String update_get (BoardDto dto, Model model)
    {
    	model.addAttribute("dto", service.read(dto));
		return "/board/edit";
    }
    
    // 수정하기
    @RequestMapping(value = "/edit_post", method = RequestMethod.POST) 
    public String update_post (BoardDto dto, MultipartFile file, HttpServletRequest request, RedirectAttributes rttr)
    {
    	String result = "fail";
    	if (service.update(dto, file, request) > 0 ) {result = "글수정에 성공했습니다.";}
    	rttr.addFlashAttribute("result", result);
    	return "redirect:/board/detail?bno=" + dto.getBno();
    }
    
    // 삭제하기 폼
    @RequestMapping(value = "/delete", method = RequestMethod.GET) 
    public void delete_get (BoardDto dto)
    {
    	log.info("........delete_view");
    }
    
    // 삭제하기
    @RequestMapping(value = "/delete_post", method = RequestMethod.POST) 
    public String delete_post (BoardDto dto, RedirectAttributes rttr)
    {
    	String result = "fail";
    	if (service.delete(dto) > 0 ) {result = "글삭제에 성공했습니다.";}
    	rttr.addFlashAttribute("result", result);
    	return "redirect:/board/list";
    }
}
