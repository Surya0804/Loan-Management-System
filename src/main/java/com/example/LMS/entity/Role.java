package com.example.LMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "role_table")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int role_id;
	@Column(name = "role_name")
private String rolename;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int role_id, String rolename) {
		super();
		this.role_id = role_id;
		this.rolename = rolename;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
