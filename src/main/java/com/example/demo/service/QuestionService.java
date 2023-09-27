package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.QuestionDao;
import com.example.demo.entity.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		try{
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	
	public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	 
	   // public ResponseEntity<List<Question>> deleteQuestionById(long id) {
	    //	try {
	    	//	return new ResponseEntity<>(questionDao.deleteQuestionById(id), HttpStatus.OK);
			//}catch(Exception e) {
				//e.printStackTrace();
			//}
			//return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		//}


}
