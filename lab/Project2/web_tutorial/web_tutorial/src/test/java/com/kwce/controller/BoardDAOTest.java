package com.kwce.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kwce.dao.BoardDAO;
import com.kwce.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새글 제목");
		board.setContent("새글 내용 입니다.");
		board.setWriter("새글 작 성 자");
		dao.create(board);
	}

}
