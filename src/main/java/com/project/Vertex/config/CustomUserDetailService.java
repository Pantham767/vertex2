package com.project.Vertex.config;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CustomUserDetailService implements UserDetailsService {



	private RegisterRepository RegRepo;

	public CustomUserDetailService(RegisterRepository regRepo) {
		RegRepo = regRepo;
	}

	@Override
	public UserDetails loadUserByUsername(@RequestParam("username") String username) throws UsernameNotFoundException {
		
		Register Reg = RegRepo.findByEmail(username);
		
		if (Reg == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(Reg);
	}
	

}
