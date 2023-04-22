package com.example.LMS.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 private int customerId;
 private String firstName;
 private String lastName;
 private int age;
 private String dob;
 private long phoneNo;
 private String state;
 private String district;
 private boolean isActive;
@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
 private List<Loan> loans=new ArrayList<>();
@PreRemove
private void preventDeletionIfHasActiveLoans() {
    if (loans.stream().anyMatch(Loan::isActive)) {
        throw new IllegalStateException("Cannot delete customer with active loans");
    }
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int customerId, String firstName, String lastName, int age, String dob, long phoneNo, String state,
		String district, boolean isActive, List<Loan> loans) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.dob = dob;
	this.phoneNo = phoneNo;
	this.state = state;
	this.district = district;
	this.isActive = isActive;
	this.loans = loans;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public long getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(long phoneNo) {
	this.phoneNo = phoneNo;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public List<Loan> getLoans() {
	return loans;
}
public void setLoans(List<Loan> loans) {
	this.loans = loans;
}

 
}
