package com.kh.sc.notice.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.notice.model.vo.Notice;

@Repository("ndao")
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertNotice(Notice notice) {
		
		return sqlSession.insert("notice-mapper.insertNotice", notice);
	}

}
