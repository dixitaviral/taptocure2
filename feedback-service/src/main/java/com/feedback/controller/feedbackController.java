package com.feedback.controller;

import java.util.List;
import java.util.Optional;

import com.feedback.service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.entity.feedback;
import com.feedback.repositry.feedbackRepositry;


@RestController
public class feedbackController {
	
	@Autowired
	private feedbackRepositry userrepo;
	@Autowired
	private feedbackService fs;
	@PostMapping("/save")
	public String saveData(@RequestBody feedback user) {
		 userrepo.save(user);
		 
		 return "save sucessfully";
		
	}
	
	@GetMapping("/get")
	public List<feedback> getdata() {
		
		List<feedback> findAll = fs.getdata();
		
		return findAll;
		
	}
	
	
	@DeleteMapping("/delete/{userId}")
	public void daletdata(@PathVariable int commentId) {
	userrepo.deleteById(commentId);
	}
	
	@PutMapping("/update")
	public String updateuser(@RequestBody feedback user) {
	        userrepo.save(user);
		return "updated sucessfull";

}
}
