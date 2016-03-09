package net.gluck.domain.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import net.gluck.domain.Account;
@RepositoryRestResource(exported = false)
public interface AccountRepository extends CrudRepository<Account, String> {	  
	  public Account findByUsername(String username);
}
