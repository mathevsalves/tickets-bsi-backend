package br.com.bsi.pi.ticketsbsi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	// 	auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	// }

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// 	return new BCryptPasswordEncoder();
	// }

	// @Bean
	// @Override
	// public AuthenticationManager authenticationManagerBean() throws Exception {
	// 	return super.authenticationManagerBean();
	// }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().disable()
				.csrf().disable().authorizeRequests().anyRequest().permitAll();
				// Não cheque essas requisições
				// todos os métodos são authenticados,exceto o options
				// .authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
				// .and().authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
				// .and().authorizeRequests().antMatchers(HttpMethod.PUT).permitAll()
				// .and().authorizeRequests().antMatchers(HttpMethod.DELETE).permitAll()
				// .and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
	}

}
