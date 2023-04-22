package com.example.LMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.LMS.entity.User;

public interface AdminRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
	List<User> findByRolesRolename(String rolename);


}
