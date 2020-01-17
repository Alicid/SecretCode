package com.kh.sc.common;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.Question.model.service.QuestionService;
import com.kh.sc.Question.model.vo.Questions;
import com.kh.sc.member.model.service.MemberService;

// Ajax기능 전용 컨트롤러
@RestController
public class AjaxController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	QuestionService qs;
	
	@RequestMapping("/member/checkIdDuplicate.do")
	public  Map<String, Object> idDupCheck(@RequestParam String userId) {
		
		boolean isUsable = memberService.checkIdDuplicate(userId)== 0? true:false;
		Map map = new HashMap();
		map.put("isUsable",isUsable);
		//System.out.println(map);
		return map;
	}
	
	@RequestMapping("/insert.tn")
	   public String fileUpload(@RequestParam(value = "file", required = false)MultipartFile[] upFiles, HttpServletRequest request) {
	      
		String savePath = 
	            request.getServletContext().getRealPath("/resources/bUpFiles/");
	      
	      String renamedFileName = null;
	      
	      for(MultipartFile f : upFiles) {
	         if( !f.isEmpty() ) {
	            // 파일 이름 재생성해서 저장하기
	            String originalFileName = f.getOriginalFilename();
	            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
	            // sample.jpg --> .jpg
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	            
	            int rndNum = (int)(Math.random()*1000);
	            
	            renamedFileName
	             = sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;  
	            // --> 20191230_154500_1.jpg
	            
	            try {
	               
	               f.transferTo(new File(savePath + renamedFileName));
	               
	            } catch (IllegalStateException e) {
	               e.printStackTrace();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	      String uploadPath = "";
	         InetAddress inet = null;
             try {
                inet = InetAddress.getLocalHost();
             } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }
             //System.out.println(request.getServerPort());
       String serverPath = "http://"+  inet.getHostAddress()+":"+request.getServerPort()+"/sc/resources/bUpFiles/"; 
	   		//System.out.println(serverPath);
	     
	      uploadPath = serverPath + renamedFileName;
	    System.out.println(uploadPath);
	      return uploadPath;
	      
	   }
	
	@RequestMapping("/update.tn")
	   public String fileUpload1(@RequestParam(value = "file", required = false)MultipartFile[] upFiles, HttpServletRequest request) {
	      
		String savePath = 
	            request.getServletContext().getRealPath("/resources/bUpFiles/");
	      
	      String renamedFileName = null;
	      
	      for(MultipartFile f : upFiles) {
	         if( !f.isEmpty() ) {
	            // 파일 이름 재생성해서 저장하기
	            String originalFileName = f.getOriginalFilename();
	            String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
	            // sample.jpg --> .jpg
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	            
	            int rndNum = (int)(Math.random()*1000);
	            
	            renamedFileName
	             = sdf.format(new Date(System.currentTimeMillis()))+"_"+rndNum+"."+ext;  
	            // --> 20191230_154500_1.jpg
	            
	            try {
	               
	               f.transferTo(new File(savePath + renamedFileName));
	               
	            } catch (IllegalStateException e) {
	               e.printStackTrace();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	      String uploadPath = "";
	      
	      InetAddress inet = null;
          try {
             inet = InetAddress.getLocalHost();
          } catch (UnknownHostException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
          }
          
          
          String serverPath = "http://"+  inet.getHostAddress()+":8088/sc/resources/bUpFiles/"; 
	     
	      uploadPath = serverPath + renamedFileName;
	    		  
	      return uploadPath;
	      
	   }
	
	@RequestMapping("/question/selectOneQuestion.do")
	public Map<String,Questions> selectOneQuestion(@RequestParam int categoryNum , @RequestParam String unitNum) {
		System.out.println("문제 출제 전 카테고리 번호 받음 확인 : "+ categoryNum);
		System.out.println("단원번호 확인 : " + unitNum);
		int unum = Integer.parseInt(unitNum);
		Map<String,Questions> map = new HashMap();
		Map<String,Integer> cMap = new HashMap();
		
		cMap.put("categoryNum", categoryNum);
		cMap.put("unitNum", unum);
		Questions qus = new Questions();
		System.out.println(cMap);
		//System.out.println("문제 출제합니다.");
		
		qus = qs.selectOneQuestion(cMap);
		map.put("question", qus);
		//System.out.println(map);
		return map;
	}
	
	@RequestMapping("/question/questionResult.do")
	public Map<String,Object> goResultPage(@RequestBody  HashMap<String, Object> map,HttpSession session) {
		System.out.println("시험결과 : "+map);
		System.out.println(map.get("Q1"));
		System.out.println(map.get("totalScore"));
		session.setAttribute("result", map);
		return map;
	}
	
	
	@RequestMapping("/question/selectUnit.do")
	public Map<String,Object> selectUnit(@RequestParam int category) {
		System.out.println("단원 확인용"+category);
		Map<String,Object> map = new HashMap();
		List<HashMap<String,String>> list =qs.selectUnitNum(category);
		System.out.println(list);
		map.put("unit", list);
		
		return map;
	}
	
}
