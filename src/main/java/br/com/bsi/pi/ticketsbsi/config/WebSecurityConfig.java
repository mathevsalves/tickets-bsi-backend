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

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and().csrf().ignoringAntMatchers("/h2-console/**")
        .and().headers().frameOptions().sameOrigin();

		httpSecurity.httpBasic().disable()
				.csrf().disable()
				// Não cheque essas requisições
				.authorizeRequests().antMatchers("**")
				.permitAll()
				// todos os métodos são authenticados,exceto o options
				.and().authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
				.and().authorizeRequests().antMatchers(HttpMethod.POST).permitAll()
				.and().authorizeRequests().antMatchers(HttpMethod.PUT).permitAll()
				.and().authorizeRequests().antMatchers(HttpMethod.DELETE).permitAll()
				.and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();
	}

}
