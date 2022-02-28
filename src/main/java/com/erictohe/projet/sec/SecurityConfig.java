/*
 * package com.erictohe.projet.sec;
 * 
 * import org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import
 * org.springframework.security.config.annotation.web.builders.WebSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth.inMemoryAuthentication().withUser("admin").roles("ADMIN").password("123"
 * );
 * auth.inMemoryAuthentication().withUser("marc").roles("USER").password("123");
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.formLogin(); //http.authorizeRequests().anyRequest().authenticated();
 * http.authorizeRequests().antMatchers("/entreprises","/taxes").hasRole("ADMIN"
 * );
 * http.authorizeRequests().antMatchers("/entreprises","/taxes").hasRole("USER")
 * ; } }
 */