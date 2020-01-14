package com.kh.sc.board.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.board.model.dao.BoardDAO;
import com.kh.sc.board.model.vo.Board;
import com.kh.sc.board.model.vo.Comment;
import com.kh.sc.common.PageInfo;
import com.kh.sc.common.exception.CustomException;


@Service
public class BoardService {

	@Autowired
	BoardDAO bdao;
	
	public int getListCount() {
		
		return bdao.getListCount();
	}

	public List<Board> selectList(PageInfo pi) {
		
		return bdao.selectList(pi);
	}

	public Board selectOne(int bno) {
		bdao.addReadCount(bno);
		return bdao.selectOne(bno);
	}
	
	public int insertBoard(Board board) {
		int result = 0;
		
		result = bdao.insertBoard(board);
		if(result<1) throw new CustomException("게시글 추가 중 에러 발생");
		
		return result;
	}
	public int updateBoard(Board board) {
		
		return bdao.updateBoard(board);
	}
	
	public int deleteBoard(int bno) {
		return bdao.deleteBoard(bno);
	}
	/*-----------------------------------------------*/
	
	public int insertComment(Comment cmt) {
		
		return bdao.insertComment(cmt);
	}

	public List<Comment> selectComments(int bno) {

		return bdao.selectComments(bno);
	}
	
	public int updateComment(Comment cmt) {
		return bdao.updateComment(cmt);
	}

	public int deleteComment(int cno) {
		
		return bdao.deleteComment(cno);
	}

	public int deleteCommentbyAdmin(int cno) {
		return bdao.deleteCommentbyAdmin(cno);
	}



	



}
