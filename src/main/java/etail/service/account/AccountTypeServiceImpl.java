package etail.service.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.account.AccountType;
import etail.repository.accounts.AccountTypesRepository;

@Service
public class AccountTypeServiceImpl implements AccountTypeService{
	public AccountTypesRepository accTypeRepo;
	
	@Autowired
	public AccountTypeServiceImpl(AccountTypesRepository accTypeRepo) {
		this.accTypeRepo = accTypeRepo;
	}

	@Override
	public List<AccountType> getAllAccountTypes() {
		List<AccountType> accList = new ArrayList<>();
		accTypeRepo.findAll().forEach(accList::add);
		
		return accList;
	}
}
