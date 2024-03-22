package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.Vertex.entity.Register;
import com.project.Vertex.service.PropertyService;

@Controller
public class LoginController {
	
	@Autowired
	PropertyService propertyService;
	
	 @GetMapping("/")
	    public String getIndexPage(Model model) {
	        model.addAttribute("register", new Register()); 
	        return "index";
	    }
	
	@GetMapping("/userSuccess")
	public String getIndexPage1(Model model) {
		//model.addAttribute("register", new Register());
		return "index1";
	}	
	
	
}
