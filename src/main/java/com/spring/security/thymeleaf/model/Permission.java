package com.spring.security.thymeleaf.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="permissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int permissionId;
	
	@Column
	String name;
	
	@Column
	String url;
	
	@ManyToMany(mappedBy = "permissions")
	@Column(nullable = true)
	private Collection<Role> roles;
	
	@Column
	@CreationTimestamp
	Date createdAt;
	
	@Column
	@UpdateTimestamp
	Date updatedAt;
}
