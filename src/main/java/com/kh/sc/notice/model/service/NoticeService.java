package com.kh.sc.notice.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.common.exception.CustomException;
import com.kh.sc.notice.model.dao.NoticeDAO;
import com.kh.sc.notice.model.vo.Notice;

@Service("bs")
public class NoticeService {

	@Autowired
	NoticeDAO ndao;
	
	public int insertNotice(Notice notice) {
		int result = 0;

		// 1. 게시글 추가
		result = ndao.insertNotice(notice);
		if (result < 1) throw new CustomException("게시글 추가 중 에러 발생");

	return result;
}

	public List<Map<String, String>> selectList(int cPage, int numPerPage) {
	      return ndao.selectList(cPage, numPerPage);
	   }

	   public int selectTotalContents() {
	      return ndao.selectTotalContents();
	   }
	   
	   public Notice selectOne(int nNo) {
		   int result = ndao.addReadCount(nNo);
		   
		   Notice n = null;
		   
		   if(result > 0) {
			   n = ndao.selectOne(nNo);
		   }
	      return n;
	   }

	public int updateNotice(Notice originNotice) {
		int result = 0;

		// 1. 게시글 수정
		result = ndao.updateNotice(originNotice);

		// 2. 추가된 게시글의 번호를 가져와
		// 첨부파일 추가하기
		if (result < 1) throw new CustomException("게시글 수정 중 에러 발생");
		
		return result;
	}

	public int deleteNotice(int nNo) {
		return ndao.deleteNotice(nNo);
	}
	
}
