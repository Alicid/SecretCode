package com.kh.sc.tResult.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.tResult.model.dao.TResultDAO;
import com.kh.sc.tResult.model.vo.Qunit;
import com.kh.sc.tResult.model.vo.tResult;

@Service("trs")
public class TResultService {
	
	@Autowired
	TResultDAO trdao;

	public int[] tresultList(int years) {
		
		System.out.println(years);
		
		tResult tr = trdao.selectList(years);
		
		System.out.println(tr);
		
		int[] array = new int[9];

		array[0] = tr.gettWtReg();
		array[1] = tr.gettWtGaz();
		array[2] = tr.gettWtCan();
		array[3] = tr.gettWtAvg();
		array[4] = tr.gettPtReg();
		array[5] = tr.gettPtGaz();
		array[6] = tr.gettPtCan();
		array[7] = tr.gettPtAvg();
		array[8] = tr.gettFinCan();
		
		System.out.println(array);
		return array;
	}

	public List<Integer> selectYears() {
		return trdao.selectYears();
	}

	public List<HashMap<String, String>> getCategoryAndGo() {
		// TODO Auto-generated method stub
		return trdao.getCategoryAndGo();
	}

	public int[] selectMyStaticsList(Map<String, Integer> map) {
		System.out.println(map);
		
		List<Qunit> list  = trdao.selectMyStaticsList(map);
		
		System.out.println(list);
		
		int[] array = new int[7];
		
		for(int i =0;i<array.length;i++) {
			array[i] = list.get(i).getUnit2();
		}
		
//		array[0] = list.get(0).getUnit2();
//		array[1] = un.getUnit2();
//		array[2] = un.getUnit3();
//		array[3] = un.getUnit4();
//		array[4] = un.getUnit5();
//		array[5] = un.getUnit6();
//		array[6] = un.getUnit7();
					
		System.out.println(array);
		return array;
	}

}
