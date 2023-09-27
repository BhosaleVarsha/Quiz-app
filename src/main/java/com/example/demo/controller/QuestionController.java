package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
		
	}
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category) {
		return questionService.getAllQuestionsByCategory(category);
		
	}
//	@PostMapping("/addQuestion")
//	public ResponseEntity<List<Question>> addQuestion(@ModelAttribute("question") Question question) {
//		return questionService.addQuestion(question);	
//	}
	@PostMapping("/addQuestion")
    public ResponseEntity<String>addQuestion(@RequestBody Question question) {
		 return questionService.addQuestion(question);
       
    }

	
	// @GetMapping("/delete/{id}")
	  //  public ResponseEntity<List<Question>> deleteQuestionById(@PathVariable long id) {
	    //    return questionService.deleteQuestionById(id);
	        
	    //}

}


