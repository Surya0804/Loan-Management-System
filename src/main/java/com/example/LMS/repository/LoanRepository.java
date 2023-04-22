package com.example.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LMS.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
