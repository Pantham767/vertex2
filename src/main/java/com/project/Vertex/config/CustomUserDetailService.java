package com.project.Vertex.config;

import com.project.Vertex.entity.Register;
import com.project.Vertex.repository.RegisterRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {



	private RegisterRepository RegRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Register Reg = RegRepo.findByEmail(username);
		if (Reg == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(Reg);
	}
	/*@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
        	throw new UsernameNotFoundException("User not found");
        }
        
		return new CustomUserDetail(user);
	}*/

}
