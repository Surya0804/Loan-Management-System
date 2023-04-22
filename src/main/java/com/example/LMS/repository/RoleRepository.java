package com.example.LMS.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LMS.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  Role findByRolename(String rolename);
}
