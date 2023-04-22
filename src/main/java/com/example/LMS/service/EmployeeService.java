package com.example.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.LMS.entity.Customer;
import com.example.LMS.entity.Loan;
import com.example.LMS.repository.CustomerRepository;
import com.example.LMS.repository.LoanRepository;

@Service
public class EmployeeService {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
	// add customer details to db
	public ResponseEntity<Customer> addCustomer(Customer customer)
	{
		
	customer.setActive(true);
	return ResponseEntity.ok(	customerRepository.save(customer));

	}
	
	//get all customers
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		return ResponseEntity.ok(customerRepository.findAll());
	}
	
	//get customer by id
	
	public ResponseEntity<Customer> getCustomerById(int id)
	{
		return ResponseEntity.ok(customerRepository.findById(id).get());
	}
	
	//update customer by id
	public ResponseEntity<Customer> updateCustomerById(int id,Customer customer)
	{
		Customer c=customerRepository.findById(id).get();
		c.setFirstName(customer.getFirstName());
		c.setLastName(customer.getLastName());
		c.setAge(customer.getAge());
		c.setDob(customer.getDob());
		c.setPhoneNo(customer.getPhoneNo());
		c.setState(customer.getState());
		c.setDistrict(customer.getDistrict());
		return ResponseEntity.ok(customerRepository.save(c));
	}
	
	//delete customer from db
	public ResponseEntity<Customer> deleteCustomerById(int id,Customer customer)
	{
		Customer c=customerRepository.findById(id).get();
		c.setActive(false);
		return ResponseEntity.ok(customerRepository.save(c));
	}
	
	//add loan to db
	public ResponseEntity<Loan> addLoan(int id,Loan loan)
	{
		Customer c=new Customer();
		c=customerRepository.findById(id).get();
		loan.setCustomer(c);
		loan.setActive(true);
		return ResponseEntity.ok(loanRepository.save(loan));
	}
	


}
