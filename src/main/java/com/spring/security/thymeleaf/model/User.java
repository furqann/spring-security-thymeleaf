package com.spring.security.thymeleaf.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public @Data class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	
	@Column
	String fullName;
	
	@Column
	String username;
	
	@Column
	String password;
	
	@Column
	String email;
	
	@Column
	boolean active;
	
	@OneToOne
	@JoinColumn(name = "role")
	Role role;
	
	@Column
	@CreationTimestamp
	Date createdAt;
	
	@Column
	@UpdateTimestamp
	Date updatedAt;
	
}
