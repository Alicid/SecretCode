package com.kh.sc.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.board.model.vo.Board;
import com.kh.sc.board.model.vo.Comment;
import com.kh.sc.common.PageInfo;


@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sql;

	public int getListCount() {
		
		return sql.selectOne("board-mapper.getListCount");
	}

	public List<Board> selectList(PageInfo pi) {
		
		return sql.selectList("board-mapper.selectBoard",pi);
	}

	public Board selectOne(int bno) {
		
		return sql.selectOne("board-mapper.selectOneBoard",bno);
	}

	public int addReadCount(int bno) {
		return sql.update("board-mapper.addReadCount",bno);
	}

	public int insertComment(Comment cmt) {
		return sql.insert("board-mapper.insertComment",cmt);
	}
	
	

}
