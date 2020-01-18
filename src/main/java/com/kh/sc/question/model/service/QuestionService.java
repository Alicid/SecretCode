package com.kh.sc.question.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.common.PageInfo;
import com.kh.sc.question.exception.QuestionException;
import com.kh.sc.question.model.dao.QuestionDAO;
import com.kh.sc.question.model.vo.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO qdao;
	
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
	
	

}
