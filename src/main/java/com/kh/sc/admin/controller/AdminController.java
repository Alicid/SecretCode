package com.kh.sc.admin.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.admin.excel.ExcelRead2;
import com.kh.sc.admin.model.service.AdminService;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.common.PageInfo;


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
		
		Question q = qs.selectOne(qNo);
		System.out.println(q);
		model.addAttribute("question", q);
		
		return "admin/questionDetail";
		
	}
	
	@RequestMapping("/excelUp.do")
	public String excelUpload(@RequestParam(value="excelFile", required=false) MultipartFile[] excelFile,
			HttpServletRequest request,
			Model model) {
		ExcelRead2 er = new ExcelRead2();
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
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				try {
					er.getXLSXExcel(savePath + "/" + renamedFileName);
				}catch (Exception e) {
					//throw new QuestionException("파일양식 미준수");
				}finally {
					dir.delete();
				}
				
			}
		}// for 끝
		loc="/question/questionList.qo";
		msg="문제 읽기 성공!";
		model.addAttribute("loc", loc).addAttribute("msg", msg);
		
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

	
	
	
	
	
	
	
	
	
	
	
}
