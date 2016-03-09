package net.gluck.domain.persistence;

import org.springframework.data.repository.CrudRepository;

import net.gluck.domain.Account;

public interface AccountRepository extends CrudRepository<Account, String> {	  
	  public Account findByUsername(String username);
}
