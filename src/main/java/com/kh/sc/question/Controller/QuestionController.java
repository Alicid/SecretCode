package com.kh.sc.question.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.sc.question.model.service.QuestionService;
import com.kh.sc.question.model.vo.Questions;
import com.kh.sc.member.model.vo.Member;
import com.kh.sc.statics.model.service.StaticsService;
import com.kh.sc.statics.model.vo.QuestionStatics;

@Controller
public class QuestionController {

	@Autowired
	QuestionService qs;
	
	@Autowired
	StaticsService ss;
	
	@RequestMapping("/question/getCategory.do")
	public String selectCategory(Model model) {
		
		List<HashMap<String,String>> list = qs.selectCategoryList();
		//System.out.println(list);
		
		model.addAttribute("category", list);
		
		return "question/CategorySelect";
	}
	
	@RequestMapping("/question/questionSelectList.do")
	public String goQuestionPage(@RequestParam String category,@RequestParam String mode,@RequestParam int unit, Model model) {
		
		System.out.println("카테고리 번호 : "+category); 
		System.out.println("단원선택 확인 : " + unit);
		int categoryNum = Integer.parseInt(category);
		System.out.println(categoryNum);
		System.out.println(mode);
		
		Map<String,Object> map = new HashMap();
		
		map.put("categoryNum", categoryNum);
		map.put("unit", unit);
		
		Map<String,String> categoryName = qs.selectCategoryName(map);
		
		if(unit==0) {
			categoryName.put("un", "전체");
			categoryName.put("unum", "0");
		}
		
		System.out.println(categoryName);
		//List<HashMap<String,String>> list = qs.selectUnitName();
		model.addAttribute("category", categoryName).addAttribute("mode", mode).addAttribute("categoryNum",categoryNum);
		
		if(mode.equals("타임어택")) {
			return "question/TimeAttack";
		}
		if(mode.equals("하드코어")) {
			return "question/hardcore";
		}
		return "question/QuestionView";
	}
	
	@RequestMapping("/question/printResult.do")
	public String printResult(HttpSession session,Model model) {
		List<QuestionStatics> list = new ArrayList<>();
		List<Questions> qlist = new ArrayList<>();
		List<Integer> tlist = new ArrayList<>();
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		Map<String,String> rmap = new HashMap<String, String>();
		Map<String,String> map = (Map<String, String>) session.getAttribute("result");
		Member m = (Member) session.getAttribute("member");
		System.out.println("화면 전달 확인 : "+map);
		System.out.println(map.keySet());
		//{Q14_3_123=0, correct=0, Q01_1_46=0, Q09_6_254=0, range=전체, Q17_3_114=0, Q07_5_205=0, mode=문제풀이 모드, Q08_1_17=0, Q05_1_30=0, Q12_2_82=0, Q03_6_298=0, Q00_1_48=0, Q02_4_176=0, Q15_4_195=0, Q13_3_128=0, Q16_4_188=0, Q06_4_183=0, totalScore=205, Q19_4_181=0, Q20_1_24=0, Q04_1_4=0, Q10_3_131=0, Q18_3_137=0, Q11_2_64=0, category=정보처리 산업기사}
//		for(String key : map.keySet()) {
//			if(key.contains("_")) {
//			}
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Entry<String,String> entry = (Entry<String,String>)entries.next();
			if(entry.getKey().contains("_")) {
				QuestionStatics qus = new QuestionStatics();
				String[] realNum = entry.getKey().split("_");
				qus.setUno(m.getuNo());
				qus.setQno(Integer.parseInt(realNum[2]));
				qus.setcNum(Integer.parseInt(realNum[1]));
				
//				if(!realNum[0].equals("Q00")) {
//					tmap.put(realNum[0], entry.getValue());
//				}
				
					tmap.put(entry.getKey(), entry.getValue());
				
				
				if(entry.getValue().equals("0")) {
					qus.setIsCorrect("N");
				}else {
					qus.setIsCorrect("Y");
				}
				System.out.println(qus);
				list.add(qus);
			}
			
		}
		rmap.put("score", map.get("correct"));
		rmap.put("total", map.get("totalScore"));
		rmap.put("mode", map.get("mode"));
		rmap.put("category", map.get("category"));
		rmap.put("range", map.get("range"));
		int result = ss.insertResult(list);
		
		
		qlist = qs.getQuestionList(tmap);
		//System.out.println("인서트 결과 "+result);
		//m.getuNo();
		System.out.println("정렬 확인 : "+tmap);
		System.out.println("결과들 확인 : " +rmap);
		for(int i=0;i<qlist.size();i++) {
			System.out.println("각 문제 번호"+qlist.get(i).getQno());
		}
		model.addAttribute("result", tmap).addAttribute("tInfo", rmap).addAttribute("qlist", qlist);
		
		
		return "question/questionScore";
	}
	
	@RequestMapping("/question/timeAttackResult.do")
	public String timeAttackResult(HttpSession session,Model model) {
		Map<String,Object> highScore = new HashMap();
		Map<String,String> map = (Map<String, String>) session.getAttribute("result");
		System.out.println("타임어택 화면 전달 확인 : "+map);
		//System.out.println(map.get("Q1"));
		Member m = (Member) session.getAttribute("member");
		int count=0;
		int answer = 0;
		int score = 0;
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Entry<String,String> entry = (Entry<String,String>)entries.next();
			if(entry.getKey().contains("Q")) {
				if(!entry.getValue().equals("0")) {
					answer++;
					score += Integer.parseInt(entry.getValue());
				}
				count++;
				
			}
		}
		
		System.out.println("카테고리 번호 확인"+map.get("categoryNum"));
		
		double answerRate = ((answer*100.0)/100.0)/((count*100.0)/100.0);
		//System.out.println("맞춘문제 : "+answer);
		//System.out.println("푼 문제"+count);
		//System.out.println("정답률 : "+answerRate);
		//System.out.println("총점수 : " + score);
		
		highScore.put("range", map.get("range"));
		highScore.put("mode", map.get("mode"));
		highScore.put("category", map.get("category"));
		highScore.put("categoryNum", map.get("categoryNum"));
		highScore.put("unitNum", map.get("unitNum"));
		highScore.put("score", score);
		highScore.put("uno", m.getuNo());
		highScore.put("correct",map.get("correct"));
		highScore.put("totalScore",map.get("totalScore"));
//		int correct = Integer.parseInt(map.get("correct"));
//		int total = Integer.parseInt(map.get("totalScore"));
//		double correctRate = correct/total;
//		double correctRate2 = Math.round((((correct*100.0)/100.0)/((total*100.0)/100.0))*1000.0)/1000.0;
//		System.out.println("정답률 확인 : " + correctRate);
//		System.out.println("정답률 확인2 : " + correctRate2);
//		highScore.put("uno",m.getuNo());
//		highScore.put("score", correctRate2);
		//System.out.println("DB 입력전 확인 : "+highScore);
		int result = ss.insertHighScore(highScore);
		
		
		
		model.addAttribute("result", highScore);
		
		
		return "question/timeAttackResult";
	}
	
}
