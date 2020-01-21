package com.kh.sc.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.common.PageInfo;
import com.kh.sc.question.exception.QuestionException;
import com.kh.sc.admin.model.dao.AdminDAO;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.admin.model.vo.Qunit;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO qdao;
	
	/*
	 * public int insertQuestion(Question question) { int result = 0;
	 * 
	 * result = qdao.insertQuestion(question); if(result < 1) throw new
	 * QuestionException("글 작성 중 에러 발생");
	 * 
	 * return result;
	 * 
	 * }
	 */
	
	public List<Question> selectList(PageInfo pi) {
		return qdao.selectList(pi);
		
	}
	
	public Question selectOne(int qNo) {
		
		
		Question q = new Question();
			q = qdao.selectOne(qNo);
		
		
		return q;
		
	}

	public int getListCount() {
		return qdao.getListCount();
	}
//
//	public int updateQuestion(Question originQuestion) {
//		int result = 0;
//		
//		result = qdao.updateQuestion(originQuestion);
//		
//		if(result < 1) throw new QuestionException("게시글 수정 중 에러 발생");
//		
//		return result;
//	}
//
//	public int deleteQuestion(int qNo) {
//		return qdao.deleteQuestion(qNo);
//	}

	public List<HashMap<String, String>> selectQunit() {
		return qdao.selectQunit();
	}

	public List<HashMap<String, String>> selectCategoryList() {
		return qdao.selectCategoryList();
	}
	
	

}
