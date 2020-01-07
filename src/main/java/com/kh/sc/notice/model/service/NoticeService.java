package com.kh.sc.notice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.notice.exception.NoticeException;
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
		if (result < 1) throw new NoticeException("게시글 추가 중 에러 발생");

	return result;
}

}
