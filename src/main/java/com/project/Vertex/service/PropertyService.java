package com.project.Vertex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Property;

public interface PropertyService {
	
	 Property saveProperty(Property property);
	 List<Property> getAllProperties();
}
