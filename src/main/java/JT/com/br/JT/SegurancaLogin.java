package JT.com.br.JT;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import JT.com.br.JT.User.User;

@Configuration
@EnableWebSecurity
public class SegurancaLogin extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	


	

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/apartment/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin(form -> form .loginPage("/login")
		.defaultSuccessUrl("/apartment/lista",true)
		.permitAll()).csrf().disable();
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder =	new BCryptPasswordEncoder();
	
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(encoder);
		
}
	
}
