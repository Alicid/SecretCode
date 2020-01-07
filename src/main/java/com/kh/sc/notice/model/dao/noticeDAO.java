package com.kh.sc.notice.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.notice.model.vo.Notice;

@Repository
public class noticeDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	public List<Map<String, String>> selectList(int cPage, int numPerPage) {
		RowBounds rows = new RowBounds((cPage-1) * numPerPage, numPerPage);
		//                    "매퍼의 실행할 SQL 명", 파라미터로 받을 값, RowBounds 전용 공간
		return sqlSession.selectList("board-mapper.selectList", null, rows);
	}

	public int selectTotalContents() {
		return sqlSession.selectOne("board-mapper.selectTotalContents");
	}

	public int insertNotice(Notice notice) {
		
		return sqlSession.insert("board-mapper.insertNotice", notice);
	}

	public Notice selectOne(int nNo) {
		return sqlSession.selectOne("board-mapper.selectNotice", nNo);
	}

	public int updateNotice(Notice originNotice) {
		
		return sqlSession.update("board-mapper.updateNotice", originNotice);
	}

	public int deleteNotice(int nNo) {
		return sqlSession.delete("board-mapper.deleteNotice", nNo);
	}
}









