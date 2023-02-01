package com.te.resumebuilder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.te.resumebuilder.service.UserService;

@SuppressWarnings("deprecation")
@EnableAutoConfiguration
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	//	http.authorizeRequests(requests -> requests.anyRequest().permitAll());
//				.antMatchers("/v1/user/register","/v1/user/register").permitAll()
//				.antMatchers("/v1/user/getUserById/**").hasAnyAuthority("USER"));
	//	http.formLogin();
	//	http.httpBasic();
		http.authorizeRequests().antMatchers("/v1/user/register","/v1/user/register","/v1/user/getUserById/**").permitAll().and().formLogin().and().httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

}
