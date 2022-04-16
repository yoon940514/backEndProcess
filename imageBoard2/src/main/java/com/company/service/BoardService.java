package com.company.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.company.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> 	list(); //전체 리스트
	public int			 	create(BoardDto dto, MultipartFile file, HttpServletRequest request);//글쓰기
	public BoardDto 		read(BoardDto dto);//상세보기 :  조회수 올리고 상세보기
	public BoardDto 		hit(BoardDto dto); // 수정글 보기 상세보기
	public int 				update(BoardDto dto, MultipartFile file, HttpServletRequest request);
	public int 				delete(BoardDto dto);
}
