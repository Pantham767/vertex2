package com.project.Vertex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Vertex.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long>{

	Register findByEmail(String email);

}
