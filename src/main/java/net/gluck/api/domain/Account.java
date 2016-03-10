package net.gluck.api.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

/* @author John Gluck
 * @date 03/08/2016
 * @description This is a DTO for security - I ripped this code
 * @link http://ryanjbaxter.com/2015/01/06/securing-rest-apis-with-spring-boot/
 */
@Entity

public class Account {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  private String username;
  private String password;
  
  public Account(){}
  
  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
}