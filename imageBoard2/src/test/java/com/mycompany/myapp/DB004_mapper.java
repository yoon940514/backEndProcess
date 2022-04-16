package com.mycompany.myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.BoardDto;
import com.company.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class DB004_mapper {
	@Autowired
	private BoardMapper testMapper;
	
	@Test
	public void testMapper() throws Exception{
		try {
			BoardDto dto = new BoardDto();
			//insert into mvcboard6 (bname, bpass, btitle, bcontent, bip, bfile) values (#{bname},#{bpass},#{btitle},#{bcontent},#{bip},#{bfile})
			dto.setBname("1");
			dto.setBpass("1");
			dto.setBtitle("1");
			dto.setBcontent("1");
			dto.setBip("1");
			dto.setBfile("1");
			log.info(".......4-2 : "+ testMapper.create(dto));
			
		}catch(Exception e) {e.printStackTrace();}
	}
}
