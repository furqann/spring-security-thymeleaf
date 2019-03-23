package com.spring.security.thymeleaf.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

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
           .formLogin().loginPage("/login").permitAll()
           .and()
           .logout().invalidateHttpSession(true);
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("furqan").password(encoder.encode("123")).roles("ADMIN");
	}
	
}
