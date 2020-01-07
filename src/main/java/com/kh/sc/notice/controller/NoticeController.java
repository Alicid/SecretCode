package com.kh.sc.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.sc.notice.model.service.NoticeService;
import com.kh.sc.notice.model.vo.Notice;

@Controller
public class NoticeController {

	@Autowired
	NoticeService ns;
	
	@RequestMapping("/notice/nInsert.no")
	public String nInsertNotice(Notice notice, Model model) {
		
	int result = 0;

	result = ns.insertNotice(notice);
	
	String msg = "";
	String loc = "/notice/noticeList.do";

	if (result > 0) {
		msg = "게시글 작성 성공";
	} else {
		msg = " 게시글 작성 실패";
	}

	model.addAttribute("msg", msg).addAttribute("loc", loc);

	return "common/msg";
}
	
	@RequestMapping("/notice/nInsertForm.no")
	public String nInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	
}
