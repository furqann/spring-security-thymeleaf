package com.spring.security.thymeleaf.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	       http
           .authorizeRequests()
           .anyRequest().authenticated()
           .and()
           .formLogin().loginPage("/").permitAll();
//               .antMatchers("/**").permitAll();
//               .antMatchers("/admin/**").permitAll()
//               .and()
//               .authorizeRequests()
//               	.anyRequest().authenticated()
//               .and()
//           .formLogin()
//               .loginPage("/admin/index")
//               .permitAll()
//               .and()
//           .logout()
//               .permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**");
	}
	
}
