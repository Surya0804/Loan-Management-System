package com.example.LMS.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.LMS.entity.Role;
import com.example.LMS.entity.User;
import com.example.LMS.repository.AdminRepository;
import com.example.LMS.repository.RoleRepository;


@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private RoleRepository roleRepository;
	//add admin
public ResponseEntity<?> addAdmin(User user)
{
	
	User user2=adminRepository.findByUsername(user.getUsername());
	if(user2==null)
	{
		User user1=new User();
		Role role=new Role();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		
		role.setRolename("ROLE_ADMIN");
		roleRepository.save(role);
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user1.setRoles(roles);
		return ResponseEntity.ok(adminRepository.save(user1)).ok("user added as admin successfully");
	}
	else
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User already present");

	}
	
}
//add employee

public ResponseEntity<?> addEmployee(User user)
{
	
	User user2=adminRepository.findByUsername(user.getUsername());
	if(user2==null)
	{
		User user1=new User();
		Role role=new Role();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		
		role.setRolename("ROLE_EMPLOYEE");
		roleRepository.save(role);
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user1.setRoles(roles);
		return ResponseEntity.ok(adminRepository.save(user1)).ok("user added as employee successfully");
	}
	else
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User already present");

	}
	
}
// add supervisor
public ResponseEntity<?> addSupervisor(User user)
{
	
	User user2=adminRepository.findByUsername(user.getUsername());
	if(user2==null)
	{
		User user1=new User();
		Role role=new Role();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		
		role.setRolename("ROLE_SUPERVISOR");
		roleRepository.save(role);
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user1.setRoles(roles);
		return ResponseEntity.ok(adminRepository.save(user1)).ok("user added as supervisor successfully");
	}
	else
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User already present");

	}

}

//add manager
public ResponseEntity<?> addManager(User user)
{
	
	User user2=adminRepository.findByUsername(user.getUsername());
	if(user2==null)
	{
		User user1=new User();
		Role role=new Role();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		
		role.setRolename("ROLE_MANAGER");
		roleRepository.save(role);
		Set<Role> roles=new HashSet<>();
		roles.add(role);
		user1.setRoles(roles);
		return ResponseEntity.ok(adminRepository.save(user1)).ok("user added as supervisor successfully");
	}
	else
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User already present");

	}

}

// get all admins
public ResponseEntity<List<User>>  getAllAdmins()
{

return ResponseEntity.ok(adminRepository.findByRolesRolename("ROLE_ADMIN"));

}

//get all employees
public ResponseEntity<List<User>>  getAllEmployees()
{

return ResponseEntity.ok(adminRepository.findByRolesRolename("ROLE_EMPLOYEE"));

}

//get all supervisors
public ResponseEntity<List<User>>  getAllSupervisors()
{

return ResponseEntity.ok(adminRepository.findByRolesRolename("ROLE_SUPERVISOR"));

}


//get all managers
public ResponseEntity<List<User>>  getAllManagers()
{

return ResponseEntity.ok(adminRepository.findByRolesRolename("ROLE_MANAGER"));

}
//get all users with roles
public ResponseEntity<List<User>>  getAllUsers()
{

return ResponseEntity.ok(adminRepository.findAll());

}


}
