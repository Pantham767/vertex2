package com.project.Vertex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.Vertex.entity.Property;
import com.project.Vertex.service.PropertyService;

@Controller
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
		
//	@PostMapping("/addPropertyForm")
//	public String showAddPropertyForm(Model model) {
//	    //model.addAttribute("property", new Property()); 
//	    return "redirect:/addProperty"; 
//	}

	
	@PostMapping("/addPropertyForm")
    public String addProperty(@ModelAttribute("property") Property property, Model model) {
        
        propertyService.saveProperty(property);
        
        return "redirect:/adminSuccess";
    }
	
	@GetMapping("/properties")
    public String getAllProperties(Model model) {
        List<Property> properties = propertyService.getAllProperties();
        model.addAttribute("properties", properties);
        return "propertyList"; 
    }
}
