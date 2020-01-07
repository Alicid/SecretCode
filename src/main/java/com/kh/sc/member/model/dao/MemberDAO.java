package com.kh.sc.member.model.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.member.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertMember(Member member) {
		return sqlSession.insert("member-mapper.insertMember", member);
	}

	public int checkIdDuplicate(String userId) {
		
		return sqlSession.selectOne("member-mapper.checkIdDuplicate", userId);
	}
	
	

}
