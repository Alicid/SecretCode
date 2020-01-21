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

import com.kh.sc.admin.excel.POIExcelManagerImpl;
import com.kh.sc.admin.exception.QuestionException;
import com.kh.sc.admin.model.service.AdminService;
import com.kh.sc.admin.model.vo.Question;
import com.kh.sc.common.PageInfo;
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
		
		if(currentPage!=0) pi.setCurrentPage(currentPage);
		
		int listCount = qs.getListCount();
		pi.calcPage(qs.getListCount());
		
		list = qs.selectList(pi);
		
		model.addAttribute("list", list).addAttribute("listCount", listCount).addAttribute("pi", pi);
		
		return "admin/questionList2";
		
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
					throw new QuestionException("파일양식 미준수");
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
	

}
