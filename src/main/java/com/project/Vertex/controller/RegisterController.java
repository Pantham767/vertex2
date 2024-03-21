package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.service.RegisterService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegisterController {
		
		@Autowired
	    private RegisterService registerService;

		@Autowired
		private PasswordEncoder PasswordEncode;
	
//		@GetMapping("/home")
//		public String home() {
//			//System.out.println("Hi");
//			return "index";
//		}
		
		
		 @GetMapping("/")
		    public String getIndexPage(Model model) {
		        model.addAttribute("register", new Register()); 
		        return "index";
		    }

		    @PostMapping("/saveRegister")
		    public String handleRegistration(@ModelAttribute("register") Register register, Model model) {
		       
		        if (register != null) {
				 	String a =	PasswordEncode.encode(register.getPassword());
					register.setPassword(a);
		            registerService.saveRegistration(register);
		            model.addAttribute("message", "Registration successful");
		           
		            return "redirect:/home"; 
		        }
		        
		        return "redirect:/home";
		    }

	@GetMapping("/usersuccess")
	public String getIndexPage1(Model model) {
		//model.addAttribute("register", new Register());
		return "index1";
	}
    
}
