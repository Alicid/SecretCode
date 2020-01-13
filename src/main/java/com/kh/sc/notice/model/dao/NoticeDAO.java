package com.kh.sc.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.common.PageInfo;
import com.kh.sc.notice.model.vo.Notice;

@Repository("ndao")
public class NoticeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertNotice(Notice notice) {
		
		return sqlSession.insert("notice-mapper.insertNotice", notice);
	}

	public List<Notice> selectList(PageInfo pi) {
		return sqlSession.selectList("notice-mapper.selectNotice",pi);
	   }
	   
	   public Notice selectOne(int nNo) {
	      return sqlSession.selectOne("notice-mapper.noticeDetail", nNo);
	   }

	public int updateNotice(Notice originNotice) {
		return sqlSession.update("notice-mapper.updateNotice", originNotice);
	}

	public int deleteNotice(int nNo) {
		return sqlSession.update("notice-mapper.deleteNotice", nNo);
	}

	public int addReadCount(int nNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("notice-mapper.addReadCount", nNo);
	}

	public int getListCount() {
		return sqlSession.selectOne("notice-mapper.getListCount");
	}
}
