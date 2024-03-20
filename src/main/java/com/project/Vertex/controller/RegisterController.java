package com.project.Vertex.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
//		@GetMapping("/home")
//		public String home() {
//			//System.out.println("Hi");
//			return "index";
//		}
		
		
		 @GetMapping("/home")
		    public String getIndexPage(Model model) {
		        model.addAttribute("register", new Register()); 
		        return "index"; 
		    }

		    @PostMapping("/saveRegister")
		    public String handleRegistration(@ModelAttribute("register") Register register, Model model) {
		        // Handle both GET and POST requests for /home
		        
		        // Check if the registration form is submitted
		        if (register != null) {
		            // Process the registration data and save it to the database
		            registerService.saveRegistration(register);
		            model.addAttribute("message", "Registration successful");
		            // Redirect to the same page after registration
		            return "redirect:/home"; 
		        }
		        
		        // If no registration data is submitted, simply return to the index page
		        return "redirect:/home";
		    }
    
}
