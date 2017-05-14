package com.monitor.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity // 禁用Boot的默认Security配置，配合@Configuration启用自定义配置（需要扩展WebSecurityConfigurerAdapter）
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用Security注解，例如最常用的@PreAuthorize
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SercurityConfig extends WebSecurityConfigurerAdapter{
	
	public static Logger logger = LoggerFactory.getLogger(SercurityConfig.class);

	@Autowired
	private UserDetailsService userDetailsServiceImpl;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/static/**","/views/**","icon/**");
		logger.debug("=================config( web )===================");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
			.csrf().disable()
			.authorizeRequests()
//			.antMatchers("/account/login").authenticated();
			.anyRequest().permitAll()
			.and().formLogin().loginPage("/account/login").successForwardUrl("/").permitAll()
			.and().logout().logoutUrl("/account/logout").logoutSuccessUrl("/").invalidateHttpSession(true).permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl);
	}
	
}
