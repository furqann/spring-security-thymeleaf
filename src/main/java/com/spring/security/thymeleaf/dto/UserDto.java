package com.spring.security.thymeleaf.dto;

import java.util.Collection;

import com.spring.security.thymeleaf.model.*;

import lombok.Data;

@Data
public class UserDto {
	User user;
	Collection<Role> roles;
}
