package com.kh.sc.question.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.sc.question.model.dao.QuestionDAO;

@Service
public class QusetionService {

	@Autowired
	QuestionDAO qdao;
	
}
