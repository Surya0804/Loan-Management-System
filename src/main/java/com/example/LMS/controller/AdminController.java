package com.example.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LMS.entity.Customer;
import com.example.LMS.entity.Loan;
import com.example.LMS.entity.Role;
import com.example.LMS.entity.User;
import com.example.LMS.service.AdminService;
import com.example.LMS.service.EmployeeService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200/")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private EmployeeService employeeService;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addadmin")
	public ResponseEntity<?> addAdmins(@RequestBody User user)
	{
		return adminService.addAdmin(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addemployee")
	public ResponseEntity<?> addEmployee(@RequestBody User user)
	{
		return adminService.addEmployee(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addsupervisor")
	public ResponseEntity<?> addSupervisor(@RequestBody User user)
	{
		return adminService.addSupervisor(user);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addmanager")
	public ResponseEntity<?> addManager(@RequestBody User user)
	{
		return adminService.addManager(user);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getadmins")
	public ResponseEntity<List<User>> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getemployees")
	public ResponseEntity<List<User>> getAllEmployees()
	{
		return adminService.getAllEmployees();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getsupervisors")
	public ResponseEntity<List<User>> getAllSupervisors()
	{
		return adminService.getAllSupervisors();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getmanagers")
	public ResponseEntity<List<User>> getAllManagers()
	{
		return adminService.getAllManagers();
	}

	
	@PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
	@GetMapping("/getallusers")
	public ResponseEntity<List<User>> getAllUsers()
	{
		return adminService.getAllUsers();
	}
	
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/addcustomers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		return employeeService.addCustomer(customer);
	}
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("/getallcustomers")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		return employeeService.getAllCustomers();
	}
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@GetMapping("/getcustomerbyid/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id)
	{
		return employeeService.getCustomerById(id);
	}
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping("/updatecustomer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id,@RequestBody Customer customer)
	{
		return employeeService.updateCustomerById(id, customer);
	}
	
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PutMapping("/deletecustomer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id,@RequestBody Customer customer)
	{
		return employeeService.deleteCustomerById(id,customer);
	}
	
	
	@PreAuthorize("hasRole('EMPLOYEE')")
	@PostMapping("/addloan/{id}")
	public ResponseEntity<Loan> addLoan(@PathVariable int id,@RequestBody Loan loan)
	{
		return employeeService.addLoan(id,loan);
	}
	

}
