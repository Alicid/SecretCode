package com.kh.sc.member.model.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.member.model.dao.MemberDAO;
import com.kh.sc.member.model.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	public int insertMember(Member member) {
		
		return memberDAO.insertMember(member);
	}

	public int checkIdDuplicate(String userId) {
		
		
		return memberDAO.checkIdDuplicate(userId);
	}
	
	public Member selectOneMember(Member member) {
			
			return memberDAO.selectOneMember(member);
	}
	
	public Member memberView(String userId) {
		return memberDAO.selectMemberView(userId);
		
	}

	public int updateMember(Member member) {
		return memberDAO.updateMember(member);
	}

	public int deleteMember(String userId) {
		return memberDAO.deleteMember(userId);
	}

}
