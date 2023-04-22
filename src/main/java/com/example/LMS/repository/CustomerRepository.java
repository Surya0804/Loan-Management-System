package com.example.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LMS.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
