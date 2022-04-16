package com.company.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.company.dto.BoardDto;
import com.company.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements  BoardService{
	@Autowired BoardMapper boardMapper;

	@Override public List<BoardDto> list() {log.info("...전체페이지"); return boardMapper.list(); }

	@Override public int create(BoardDto dto, MultipartFile file, HttpServletRequest request) { 
		try {
			dto.setBip(InetAddress.getLocalHost().getHostName()); }
		catch (Exception e) {e.printStackTrace();}
		try {
			dto.setBfile(fileupload(file.getOriginalFilename(), request, file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return boardMapper.create(dto); 
	}
	
	public String fileupload(String originalFilename, HttpServletRequest request, byte[] fileData) throws IOException
	{
		String saveName = UUID.randomUUID().toString() + "_" + originalFilename;
		// 2. 파일업로드
		String path="C:\\upload";
		//String path = request.getSession().getServletContext().getRealPath("/") + "upload";
		// 호스팅용
		
		File target = new File(path, saveName);	// File (파일경로, 파일이름)
		FileCopyUtils.copy(fileData, target);
		
		return saveName;
	}
	
	@Transactional
	@Override public BoardDto read(BoardDto dto) { 
		log.info("...조회수올리기 + 상세보기");
				boardMapper.hit(dto);
		return boardMapper.read(dto); }

	@Override public BoardDto hit(BoardDto dto) { 
		log.info("...수정하기화면");
		return boardMapper.read(dto); }

	@Override public int update(BoardDto dto, MultipartFile file, HttpServletRequest request) { 
		log.info("...수정하기");
		dto.setBfile(request.getParameter("prev_file"));
		
		if (file.getOriginalFilename().length() != 0)
		{
			try {
				dto.setBfile(fileupload(file.getOriginalFilename(), request, file.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		return boardMapper.update(dto); }

	@Override public int delete(BoardDto dto) { 
		log.info("...삭제하기");
		return boardMapper.delete(dto); }

	

	
}
