package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Property;
import com.project.Vertex.repository.PropertyRepository;
import com.project.Vertex.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

		@Autowired
	    private PropertyRepository propertyRepository;

	    @Override
	    public Property saveProperty(Property property) {
	        return propertyRepository.save(property);
	    }

		@Override
		public List<Property> getAllProperties() {
			return propertyRepository.findAll();
			
		}

}
