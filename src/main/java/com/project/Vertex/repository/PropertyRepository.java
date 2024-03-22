package com.project.Vertex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Vertex.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
	
	 List<Property> findAll();
	
}
