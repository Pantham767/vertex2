package com.project.Vertex.controller;

import java.util.Base64;
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

	
	
	
	@GetMapping("/adminSuccess")
	public String showAdminPageAndRetriveProperties(Model model) {
		model.addAttribute("property", new Property());
		 List<Property> properties = propertyService.getAllProperties();
		 encodeImages(properties);
		    model.addAttribute("properties", properties);
		    
		
		return "main";
	}
	
	@PostMapping("/addPropertyForm")
    public String addProperty(@ModelAttribute("property") Property property, Model model) {
		 encodeImage(property);
		// model.addAttribute("property", new Property());
		model.addAttribute("property", new Property());
		 List<Property> properties = propertyService.getAllProperties();
		    model.addAttribute("properties", properties);
        propertyService.saveProperty(property);
        
        return "main";
        
        
    }
	
	// Helper method to encode images
	private void encodeImage(Property property) {
	    byte[] image1 = property.getImage1();
	    if (image1 != null) {
	        String image1Base64 = Base64.getEncoder().encodeToString(image1);
	        
	    }
	    
	    byte[] image2 = property.getImage2();
	    if (image2 != null) {
	        String image2Base64 = Base64.getEncoder().encodeToString(image2);
	     
	    }
	}

    // Helper method to encode images in a list of properties
    private void encodeImages(List<Property> properties) {
        for (Property property : properties) {
            encodeImage(property);
        }
    }
	
}
