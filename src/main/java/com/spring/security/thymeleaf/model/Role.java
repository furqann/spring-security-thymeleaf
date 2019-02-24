package com.spring.security.thymeleaf.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int roleId;
	
	@Column
	String name;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
	@JoinTable(name="roles_permissions", 
	joinColumns=@JoinColumn(name="role_id"), inverseJoinColumns=@JoinColumn(name="permission_id"))
	@Column(nullable = true)
	private Collection<Permission> permissions;
	
	@Column
	@CreationTimestamp
	Date createdAt;
	
	@Column
	@UpdateTimestamp
	Date updatedAt;
}
