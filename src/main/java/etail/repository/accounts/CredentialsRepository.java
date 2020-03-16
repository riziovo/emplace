package etail.repository.accounts;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.account.Credential;

@Repository
public interface CredentialsRepository extends CrudRepository<Credential, Long>{
	public Optional<Credential> findByUsername(String username);
	public Optional<Credential> findByEmail(String email);
	public Credential findByPhNum(String ph);
}