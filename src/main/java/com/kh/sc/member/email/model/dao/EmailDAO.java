package com.kh.sc.member.email.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.member.model.vo.Member;

@Repository
public class EmailDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	/*
	 * public int checkEmail(String email) { return
	 * sqlSession.selectOne("email-mapper.checkEmail", email); }
	 */

	public String sendEmail(String email) {
		return sqlSession.selectOne("member-mapper.checkEmail", email);
	}
	public int updatePw(Member member) throws Exception {
		return sqlSession.update("member-mapper.updatePw", member);
	}
	public int userConfirm(Member member) {
		return sqlSession.selectOne("member-mapper.userConfirm",member);
	}
	/*
	 * public int emailConfirm(Email email) { return
	 * sqlSession.update("email-mapper.emailConfirm", email); }
	 * 
	 * public int emailConfirmDelete(Email email) { return
	 * sqlSession.delete("email-mapper.emailConfirmDelete", email); }
	 */

	

}
