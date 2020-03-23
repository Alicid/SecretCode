package com.kh.sc.question.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.sc.question.model.vo.Questions;
import com.kh.sc.statics.model.vo.QuestionStatics;

@Repository
public class QuestionDAO {

	@Autowired
	SqlSessionTemplate sql;
	
	public Questions selectOneQuestion(Map<String, Integer> cMap) {
		// 랜덤 문제 받아오기
		int qNum = sql.selectOne("question-mapper.selectQuestionNum", cMap);
		System.out.println("랜덤 문제 번호" + qNum);
		Questions qn = new Questions();
		qn.setQno(qNum);
		//qn.setQuPkno(cMap);
		//System.out.println(qn);
		// 받은 문제번호의 내용 가져오기
		return sql.selectOne("question-mapper.selectOneQuestion",qn);
	}
	
	public List<HashMap<String,String>> selectCategoryList() {
		// 전체 문제 카테고리 리스트
		return sql.selectList("question-mapper.selectCategoryList");
	}

	public Map selectCategoryName(Map<String, Object> map) {
		
		return sql.selectOne("question-mapper.selectCategoryName",map);
	}

	public List<HashMap<String,String>> selectUnitNum(int category) {
		
		return sql.selectList("question-mapper.selectUnitNum",category);
	}

	public List selectHighScore() {
		return sql.selectList("statics-mapper.timeAttackRanking");
	}

	public List<Questions> getQuestionList(TreeMap<String, String> tmap) {
		ArrayList<Questions> qlist = new ArrayList<>();
		
		Iterator<Map.Entry<String, String>> entries = tmap.entrySet().iterator();
		while(entries.hasNext()) {
			Entry<String,String> entry = (Entry<String,String>)entries.next();
			
				
				String[] realNum = entry.getKey().split("_");
				int num = Integer.parseInt(realNum[2]);
				Questions qus = new Questions();
				qus=sql.selectOne("question-mapper.selectOneQuestion",num);
				qlist.add(qus);

		}
		return qlist;
	}

	
}
