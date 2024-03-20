package com.project.Vertex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import com.project.Vertex.service.RegisterService;

@Service
public class RegistorServiceImpl implements RegisterService{

	@Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register saveRegistration(Register register) {
        return registerRepository.save(register);
    }
}
