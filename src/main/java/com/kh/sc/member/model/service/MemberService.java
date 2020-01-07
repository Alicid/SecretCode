package com.kh.sc.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.member.model.dao.MemberDAO;
import com.kh.sc.member.model.vo.Member;
@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	public int insertMember(Member member) {
		
		return 0;
	}

	public Member selectOneMember(Member member) {
		
		return memberDAO.selectOneMember(member);
	}
	
	public Member memberView(String userId) {
		return memberDAO.selectOneMember(userId);
		
	}

}
