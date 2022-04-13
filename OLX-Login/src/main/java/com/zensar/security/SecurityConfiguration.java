package com.zensar.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.password.PasswordEncoder;



@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception { // Used for Authentication
		
		auth.userDetailsService(userDetailsService);
		
		/*
		auth.inMemoryAuthentication()
		.withUser("pavan").password(this.passwordEncoder.encode("pavan007")).roles("ADMIN")
		.and()
		.withUser("tom").password(this.passwordEncoder.encode("tom123")).roles("USER")
		.and()
		.withUser("jerry").password(this.passwordEncoder.encode("jerry123")).roles("USER");
		*/
	}
	
	@Bean
	public PasswordEncoderParser getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception { // Used for Authorization
		http.authorizeRequests()
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/all").permitAll()
		.and()
		.formLogin();
	}

}

