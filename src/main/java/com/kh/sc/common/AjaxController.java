package com.kh.sc.common;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.sc.member.model.service.MemberService;

// Ajax기능 전용 컨트롤러
@RestController
public class AjaxController {

	@Autowired
	MemberService memberService;
	
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
	
	@RequestMapping("/common/crawling.do")
	public Map<String, String> crawling() throws Exception{
		
		String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC%EC%82%B0%EC%97%85%EA%B8%B0%EC%82%AC";
		//String url = "http://www.edupure.net/v/l0/n0401.asp?lcode=2";
		System.out.println("===========================");
		System.out.println("url: " + url);
		String selector = "div.list_bx";
		//String selector = "table.board1";
		Document doc = Jsoup.connect(url).get();
		
		Elements element = doc.select(selector);
		 Map<String,String> map = new HashMap();
		 String newElement = element.html();
		map.put("crawl", newElement);
		
		
		System.out.println(element);
		System.out.println("=================");
		System.out.println(element.outerHtml());
		return map;
		}
	
}
