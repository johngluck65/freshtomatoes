package net.gluck.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/* @author John Gluck
 * @date 03/08/2016
 * @description This is a DTO for security - I ripped this code
 * @link http://ryanjbaxter.com/2015/01/06/securing-rest-apis-with-spring-boot
 */

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
    //may want to do something other than basic
    httpBasic().and().
    //TODO: Cross-Site Scripting tokens might want to be enabled.  they aren't because
    // it seemed like it was painful and time consuming.
    csrf().disable();
  }
  
}
