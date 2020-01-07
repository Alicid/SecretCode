package com.kh.sc.member.model.dao;

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

	public Member selectOneMember(Member member) {
		return sqlSession.selectOne("member-mapper.selectOneMember", member);
	}

	public Member selectOneMember(String userId) {
		return sqlSession.selectOne("member-mapper.selectMemberView", userId);
	}
	
	

}
