package com.example.LMS.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "loan_table")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loanId;
	private String loanName;
	private int loanAmount;
	private int aadhar;
	private String pancard;
	private String occupation;
	private int salary;
	private String assignedTo;
	private String dateOfRequest;
	private String dateOfCompletion;
	private String employeeComments;
	private String supervisorComments;
	private String managerComments;
	private boolean isActive;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="customerId",referencedColumnName = "customerId")
	private Customer customer;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(int loanId, String loanName, int loanAmount, int aadhar, String pancard, String occupation, int salary,
			String assignedTo, String dateOfRequest, String dateOfCompletion, String employeeComments,
			String supervisorComments, String managerComments, boolean isActive, Customer customer) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.loanAmount = loanAmount;
		this.aadhar = aadhar;
		this.pancard = pancard;
		this.occupation = occupation;
		this.salary = salary;
		this.assignedTo = assignedTo;
		this.dateOfRequest = dateOfRequest;
		this.dateOfCompletion = dateOfCompletion;
		this.employeeComments = employeeComments;
		this.supervisorComments = supervisorComments;
		this.managerComments = managerComments;
		this.isActive = isActive;
		this.customer = customer;
	}
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getAadhar() {
		return aadhar;
	}
	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getDateOfCompletion() {
		return dateOfCompletion;
	}
	public void setDateOfCompletion(String dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}
	public String getEmployeeComments() {
		return employeeComments;
	}
	public void setEmployeeComments(String employeeComments) {
		this.employeeComments = employeeComments;
	}
	public String getSupervisorComments() {
		return supervisorComments;
	}
	public void setSupervisorComments(String supervisorComments) {
		this.supervisorComments = supervisorComments;
	}
	public String getManagerComments() {
		return managerComments;
	}
	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
