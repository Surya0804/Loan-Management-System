package com.example.LMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LMS.entity.User;
import com.example.LMS.helper.JwtUtil;
import com.example.LMS.repository.AdminRepository;
import com.example.LMS.service.CustomUserDetailsService;

import io.jsonwebtoken.Header;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class GenerateJwtToken {
	@Autowired
private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception
	{
		try
		{
			User user1=adminRepository.findByUsername(user.getUsername());
			if(user1.getPassword().equals(user.getPassword()))
			{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
			}
		}
		catch(BadCredentialsException e)
		{
			e.printStackTrace();
		}
		UserDetails userDetails=customUserDetailsService.loadUserByUsername(user.getUsername());
		String token=jwtUtil.generateToken(userDetails);
		System.out.println(token);
		return ResponseEntity.ok(token);
	}

}
