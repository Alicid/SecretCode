package com.kh.sc.tResult.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.tResult.model.dao.TResultDAO;
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

}
