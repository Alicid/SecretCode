package com.kh.sc.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.kh.sc.admin.exception.QuestionException;
import com.kh.sc.admin.model.service.AdminService;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.common.PageInfo;
import com.kh.sc.member.model.vo.Member;
import com.kh.sc.notice.model.vo.Notice;
import com.kh.sc.question.model.vo.Answer;
import com.kh.sc.admin.excel.*;


@Controller
public class AdminController {
	
	@Autowired
	AdminService qs;
	
	@RequestMapping("/admin/adminQuestion.do")
	public String adminQuestion() {
		
		return "admin/adminQuestion";
	}
	
	@RequestMapping("/admin/questionInsert.do")
	public String questionInsert() {
		
		return "admin/adminQuestion";
	}
	
	@RequestMapping("/question/questionList.qo")
	public String selectquestionList(@RequestParam(value="currentPage", required=false, defaultValue="0") 
			int currentPage, Model model) {
				
		List<Question> list = new ArrayList<Question>();
		PageInfo pi = new PageInfo();
		List<HashMap<String,String>> qcList = qs.selectCategoryList();
		
		if(currentPage!=0) pi.setCurrentPage(currentPage);
		
		int listCount = qs.getListCount();
		pi.calcPage(qs.getListCount());
		
		list = qs.selectList(pi);
		
		model.addAttribute("list", list).addAttribute("listCount", listCount).addAttribute("pi", pi).addAttribute("category", qcList);
		
		return "admin/questionList";
		
	}
	
	@RequestMapping("/question/questionDetail.qo")
	public String selectOne(@RequestParam("qNo") int qNo, Model model) {
		List<Answer> cAnswer= new ArrayList();
		List<Answer> wAnswer= new ArrayList();
		Question q = qs.selectOne(qNo);
		 cAnswer = qs.selectCorrectAnswers(qNo);
		 wAnswer = qs.selectWrongAnswers(qNo);
		System.out.println(q);
		System.out.println("정답 목록 : "+cAnswer);
		System.out.println("오답 목록 : "+wAnswer);
		model.addAttribute("question", q).addAttribute("cAnswer", cAnswer).addAttribute("wAnswer", wAnswer);
		
		return "admin/questionDetail";
		
	}
	@RequestMapping("/excelUp.do")
	public String excelUpload(@RequestParam(value="excelFile", required=false) MultipartFile[] excelFile,
			HttpServletRequest request,
			Model model,
			HttpSession session) {
		System.out.println("엑셀 문제파일 업로드");
		List<List<Object>> list = new ArrayList<List<Object>>();
		ExcelRead er = new ExcelRead();
		Member m = (Member) session.getAttribute("member");
		int uno = m.getuNo();
		String msg = "";
		String loc = "";
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/temp");
		File dir = new File(savePath);
		if(dir.exists()==false) dir.mkdir();
		for(MultipartFile f : excelFile) {
			System.out.println("f:"+f);
			System.out.println("ftype:"+f.getClass().getName());
			if(!f.isEmpty()) {
				// 파일 이름 재생성해서 저장하기
				//f.transferTo(savePath);
				
				String originalFileName = f.getOriginalFilename();
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".")+1);
				System.out.println(ext);
				if(!ext.equals("xlsx")) {
					loc = "/question/questionList.qo";
					msg ="xlsx 파일만 입력 가능합니다.";
					model.addAttribute("loc", loc).addAttribute("msg", msg);
					
					return "common/msg";
				}
				// sample.jpg ---> .jpg
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
				int rndNum = (int)(Math.random()*1000);
				String renamedFileName = sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;
		
				try {
					f.transferTo(new File(savePath + "/" + renamedFileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					 list = er.getXLSXExcel2(savePath + "/" + renamedFileName,uno);
					//er.getXLSXExcel(savePath + "/" + renamedFileName,uno);
				}catch (Exception e) {
					//throw new QuestionException("파일양식 미준수");
				}finally {
					dir.delete();
				}
				
			}
		}// for 끝
		System.out.println("엑셀 읽어온 결과 :" + list);
		
		int result = qs.insertQuestions(list);
		
		loc="/question/questionList.qo";
		msg="문제 읽기 성공!";
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
		return "common/msg";
	}
	@RequestMapping("/admin/adminMemberList.qo")
	public String selectadminMemberList(Model model) {
		
		List<Member> list = new ArrayList<>();
		
		
		
		list = qs.selectadminMemberList();
		System.out.println(list);
		model.addAttribute("list", list); 
		return "admin/adminMemberList"; 
	
}
	@RequestMapping("/admin/adminMemberUpdate.qo")
	public String adminMemberUpdate(@RequestParam int memberGrade,@RequestParam int uno,Model model) {
		System.out.println("회원번호 : "+uno);
		System.out.println("회원 등업시킬 번호 : "+memberGrade);
		Member m = new Member();
		m.setuNo(uno);
		m.setaNo(memberGrade);
		System.out.println(m);
		String msg = "";
		String loc = "";
		int result = qs.adminMemberUpdate(m);
		
		msg="등급변경 성공!";
		loc="/admin/adminMemberList.qo";	
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	@RequestMapping("/question/questionSearchList.do")
	public String questionSearchList(@RequestParam String searchContent, 
			                                                  @RequestParam int category, 
			                                                  @RequestParam int unit, 
			                                                  @RequestParam(value="currentPage", required=false, defaultValue="1") 
																int currentPage, Model model) {
		
		System.out.println("시험 분류 : " + category );
		System.out.println("단원 번호 : " + unit);
		System.out.println("키워드 : " + searchContent);
		System.out.println("현재 페이지 : "  + currentPage);
		List<Question> list = new ArrayList<Question>();
		PageInfo pi = new PageInfo();
		pi.setCurrentPage(currentPage);
		pi.setEndPage(currentPage + 4);
		
		HashMap<String, Object> map = new HashMap();
		
		map.put("category", category);
		map.put("unit", unit);
		map.put("searchContent", searchContent);
		
		int sListCount = qs.getsListCount(map);
		pi.calcPage(qs.getsListCount(map));
		map.put("startRow", pi.getStartRow());
		map.put("endRow", pi.getEndRow());
		map.put("currentPage", pi.getCurrentPage());
		
		List<HashMap<String,String>> categoryList = qs.selectCategoryList();
		
		List<HashMap<String,String>> qcList = qs.searchList(map); // 맵을 담아 리스트 검색하기
		
		model.addAttribute("category", categoryList)
		.addAttribute("selectedCategory", category)
		.addAttribute("unit", unit)
		.addAttribute("pi", pi)
		.addAttribute("listCount", sListCount)
		.addAttribute("searchContent", searchContent)
		.addAttribute("list", qcList);
		
		return "admin/questionList";
	}
	@RequestMapping("/admin/updateQuestionView.qo")
	public String updateQuestionView(@RequestParam int qNo,Model model) {
		System.out.println("수정화면컨트롤러 qNo 도착 확인 " + qNo);
		Question que = qs.updateQuestionView(qNo);
		System.out.println(que);
		model.addAttribute("q", que);

		return "admin/questionUpdateForm";
	}
	
	@RequestMapping("/admin/updateQuestion.qo")
	public String updateQuestion(Question q,Model model) {
		System.out.println("수정컨트롤러 수정값 도착 확인 :"+ q);
		
		int result = qs.updateQuestion(q);
		String msg = "";
		String loc = "";
		if(result>0) {
			msg = "문제 수정 성공!";
			loc = "/question/questionList.qo";
		}else {
			msg = "문제 수정 실패!";
			loc = "/question/questionList.qo";
		}
		model.addAttribute("msg", msg).addAttribute("loc", loc);
		return "common/msg";
	}
}
