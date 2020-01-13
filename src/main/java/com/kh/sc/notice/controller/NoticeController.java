package com.kh.sc.notice.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.common.util.Utils;
import com.kh.sc.notice.model.service.NoticeService;
import com.kh.sc.notice.model.vo.Notice;

@Controller
public class NoticeController {

	@Autowired
	NoticeService ns;
	
	@RequestMapping("/notice/noticeList.no")
	   public String selectNoticeList(@RequestParam(value = "cPage", required = false, defaultValue = "1") int cPage,
	         Model model) {

	      // 한 페이지당 보여줄 게시글 수
	      int numPerPage = 10;

	      // 페이지 처리된 리스트 가져오기
	      List<Map<String, String>> list = ns.selectList(cPage, numPerPage);

	      // 전체 게시글 수 가져오기
	      int totalContents = ns.selectTotalContents();

	      // 페이지 계산 HTML을 추가하기
	      String pageBar = Utils.getPageBar(totalContents, cPage, numPerPage, "noticeList.no");

	      System.out.println(pageBar);

	      model.addAttribute("list", list).addAttribute("totalContents", totalContents)
	            .addAttribute("numPerPage", numPerPage).addAttribute("pageBar", pageBar);

	      return "notice/noticeList";   
	   }
	   
	   @RequestMapping("/notice/noticeDetail.no")
	   public String selectOne(@RequestParam("nNo") int nNo, Model model) {
	      
	      Notice n = ns.selectOne(nNo);   
	      
	      model.addAttribute("notice", n);       
	      
	      return "notice/noticeDetail";
	   }
	
	@RequestMapping("/notice/nInsert.no")
	public String nInsertNotice(Notice notice, Model model) {
		System.out.println(notice);
	int result = 0;

	result = ns.insertNotice(notice);
	
	String msg = "";
	String loc = "/notice/noticeList.no";

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
	
	@RequestMapping("/notice/nUpdateForm.no")
	public String nUpdateForm(@RequestParam int nNo, Model model) { 
		model.addAttribute("notice", ns.selectOne(nNo));
		return "notice/noticeUpdateForm";
	}
	

	
	@RequestMapping("/notice/nUpdate.no")
	public String noticeUpdate(Notice notice, Model model, HttpServletRequest request) {

		int nNo = notice.getnNo();

		// 원본 게시글 수정 부분
		Notice originNotice = ns.selectOne(nNo);
		originNotice.setnTitle(notice.getnTitle());
		originNotice.setnContent(notice.getnContent());

		int result = ns.updateNotice(originNotice);

		String msg = "";
		String loc = "/notice/noticeDetail.no?nNo=" + nNo;

		if (result > 0) {
			msg = "게시글 수정 성공";
		} else {
			msg = " 게시글 수정 실패";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);

		return "common/msg";
	}


	
	@RequestMapping("/notice/nDelete.no")
	public String noticeDelete(int nNo, Model model, HttpSession session) {

		System.out.println("-----------");
		int result = ns.deleteNotice(nNo);
	
		String msg = "";
		String loc = "/notice/noticeList.no";

		if (result > 0) {
			msg = "게시글 삭제 성공!";

		} else {
			msg = "게시글 삭제 실패";
		}

		model.addAttribute("msg", msg).addAttribute("loc", loc);

		return "common/msg";
	}
	
	
}
