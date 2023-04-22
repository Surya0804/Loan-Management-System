package com.example.LMS.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.LMS.entity.Role;
import com.example.LMS.entity.User;
import com.example.LMS.repository.AdminRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
private AdminRepository adminRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= adminRepository.findByUsername(username);
		
		Set<GrantedAuthority> authorities=new HashSet<>();
		for(Role role:user.getRoles())
		{
			authorities.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	   
	}

}
