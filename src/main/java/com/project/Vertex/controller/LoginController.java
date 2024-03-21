package com.project.Vertex.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Vertex.entity.Property;

@Controller
public class LoginController {
	
	@GetMapping("/userSuccess")
	public String getIndexPage1(Model model) {
		//model.addAttribute("register", new Register());
		return "index1";
	}	
	
	@GetMapping("/adminSuccess")
	public String addProperty(Model model) {
		 model.addAttribute("property", new Property());
		return "main";
	}
}
