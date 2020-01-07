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

}
