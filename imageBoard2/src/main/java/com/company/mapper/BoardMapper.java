package com.company.mapper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.company.dto.BoardDto;

public interface BoardMapper {
	public List<BoardDto> 	list();
	public int			 	create(BoardDto dto);
	public BoardDto 		read(BoardDto dto);
	public int 				hit(BoardDto dto);
	public int 				update(BoardDto dto);
	public int 				delete(BoardDto dto);
}
/*
 1. 전체 mvcboard2 게시판을 출력하는 sql구문
  	select * from mvcboard2 order by bno desc

2. 시퀀스 seq_mvcboard.nextval를 이용하여 글 한개를 입력받아 삽입 하는 sql구문
	insert into mvcboard2 (bname, bpassn, btitle, bcontent, bip) values ('1','1','1','1','1')

3. 해당글 번호의 게시판 출력
	select * from mvcboard2 where bno=1
	
4. 조히수를 1개 올리는 구문
	update mvcboard2 set bhit = bhit+1 where bno=?
	
5. 해당글 번호와 비번이 맞다면 제목과 내용을 수정하는 구문
	update mvcboard2 set btitle = '_new' , bcontent='1_content' where bno= 141 and bpass='1';

6. 해당글 번호와 비번이 맞다면 해당글을 삭제하는 구문을 작성후 테스트하시오
	delete from mvcboard2 where bno = 141 and bpass='1';
	
	
  
  
  
  
  
  
  */
 