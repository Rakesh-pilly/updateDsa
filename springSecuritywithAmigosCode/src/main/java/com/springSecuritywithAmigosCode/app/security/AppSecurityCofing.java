package com.springSecuritywithAmigosCode.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityCofing extends WebSecurityConfigurerAdapter {
	
	
	  private final PasswordEncoder passwordEncoder;
	  
	  
	 @Autowired
	public AppSecurityCofing(PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http 
				.authorizeRequests()
				.antMatchers("/","index", "/css/*", "/js/*")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
		


	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		
	UserDetails rakeshUser = 	User.builder().username("rakesh")
		.password(passwordEncoder.encode("abc"))
		.roles("STUDENT")
		.build();
	
	UserDetails rameshUser = User.builder().username("ramesh")
	.password(passwordEncoder.encode("abc"))
	.roles("ADMIN")
	.build();
	
	return new InMemoryUserDetailsManager(rakeshUser,rameshUser );
	
	
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}
	
	
	
}
