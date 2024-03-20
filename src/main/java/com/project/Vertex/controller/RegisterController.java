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
		        return "index2";
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

	@PostMapping("/saveRegister1")
	public String handleRegistration(@RequestParam("email") String email,
									 @RequestParam("mobileNumber") String mobileNumber,
									 @RequestParam("preferredLocation") String preferredLocation,
									 @RequestParam("password") String password,
									 @RequestParam("confirmPassword") String confirmPassword,
									 Model model) {
		// Handle the registration process using the provided parameters
		// You can perform validation, save to the database, etc.
		System.out.println(email);

		// Assuming the registration is successful, you can redirect to the success page
		return "redirect:/success";
	}
    
}
