package etail.repository.accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.account.AccountType;

@Repository
public interface AccountTypesRepository extends CrudRepository<AccountType, Long>{
}
