package com.kh.sc.member.email.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.kh.sc.member.email.emailHandler.EmailHandler;
import com.kh.sc.member.email.model.dao.EmailDAO;
import com.kh.sc.member.email.model.vo.Email;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	EmailDAO emailDao;
	
	@Autowired
	Email email;

	/*
	 * public int checkEmail(String email) { return emailDao.sendEmail(email); }
	 */
	
	public String sendEmail(String email) throws Exception {

		String userId = emailDao.sendEmail(email);
		
		String msg = "";
		
		if(userId == null || userId == "") {
			msg="입력하신 이메일이 존재하지 않습니다.";
		} else {
			
			EmailHandler sendMail = new EmailHandler(mailSender);
			
			sendMail.setSubject("시크릿코드 문의하신 아이디 입니다.");
			sendMail.setText(userId);
			sendMail.setFrom("zerous1318@gmail.com", "시크릿코드 고객센터");
			sendMail.setTo(email);
			sendMail.send();
			
			msg = "입력하신 이메일로 ID를 전송 해드렸습니다.";
		}
		
		
		return msg;
	}

	/*
	 * public int emailConfirm(String userId, String key) {
	 * 
	 * email.setEmail(userId); email.setKey(key);
	 * 
	 * return emailDao.emailConfirm(email); }
	 * 
	 * public int emailConfirmDelete(String userId, String key) {
	 * 
	 * email.setEmail(userId); email.setKey(key);
	 * 
	 * return emailDao.emailConfirmDelete(email);
	 * 
	 * }
	 */
	
}






