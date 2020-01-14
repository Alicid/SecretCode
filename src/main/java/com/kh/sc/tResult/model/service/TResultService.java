package com.kh.sc.tResult.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.tResult.model.dao.TResultDAO;

@Service("trs")
public class TResultService {
	
	@Autowired
	TResultDAO trdao;

	public int[] tresultList(int years) {
		
		List<HashMap<String, String>> map = trdao.selectList(years);
		
		int[] array = new int[map.size() * 2];
		int i = 0;
		for(HashMap<String, String> m : map) {
			
			array[i++] = Integer.parseInt(m.get("C"));
			
			if(i+1 == map.size()*2) {
				
				array[i] = Integer.parseInt(m.get("E"));
				
			} else {
				
				array[i++] = Integer.parseInt(m.get("E"));
				
			}
		}
		
		return array;
	}

}
