package com.kh.sc.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kh.sc.notice.exception.noticeException;
import com.kh.sc.notice.model.dao.noticeDAO;
import com.kh.sc.notice.model.vo.Notice;

@Service
public class noticeService {
	
	@Autowired
	noticeDAO noticeDAO;

	public List<Map<String, String>> selectList(int cPage, int numPerPage) {
		return noticeDAO.selectList(cPage, numPerPage);
	}

	public int selectTotalContents() {
		return noticeDAO.selectTotalContents();
	}
	@Transactional(propagation=Propagation.REQUIRED,
				   isolation=Isolation.READ_COMMITTED)
	public int insertBoard(Notice notice)
			throws noticeException { 
		int result = 0;
	
		// 1. 게시글 추가
		result = noticeDAO.insertNotice(notice);
		if(result < 1) throw new noticeException("게시글 추가 중 에러 발생!");
		
		/*
		 * // 2. 추가된 게시글의 번호를 가져와 // 첨부파일 추가하기 if(list.size() > 0) { for(Attachment a :
		 * list) { result = boardDAO.insertAttachment(a); // 확인용 result 값 변경하기 //result
		 * = 0; if(result < 1) throw new BoardException("첨부파일 추가 중 에러 발생!"); } }
		 */
		
		return result;
	}

	public Notice selectOne(int nNo) {
		return noticeDAO.selectOne(nNo);
	}

	/*
	 * public List<Attachment> selectAttachment(int boardNo) { return
	 * boardDAO.selectAttachment(boardNo); }
	 */

	
	  public int updateNotice(Notice originNotice) { int result = 0;
	  	  
	  result = noticeDAO.updateNotice(originNotice);
	  
	  if(result > 0) { 
	  result = noticeDAO.deleteNotice(originNotice.getnNo());
	  
	  }
	 	  return result; 
}
	  
	  
	 
	public int deleteNotice(int nNo) {
		
		return noticeDAO.deleteNotice(nNo);
	}
	
}