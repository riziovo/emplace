package etail.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.account.Credential;
import etail.repository.accounts.CredentialsRepository;

@Service
public class CredentialServiceImpl implements CredentialService{
	public CredentialsRepository credRepo;
	
	@Autowired
	public CredentialServiceImpl(CredentialsRepository credRepo) {
		this.credRepo = credRepo;
	}

	@Override
	public boolean verifyAccountByUsername(String uname) {
		return credRepo.findByUsername(uname).isPresent();
	}

	@Override
	public boolean recoverAccountByUsername(String uname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recoverAccountByEmail(String uname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyAccountByEmail(String email) {
		// TODO Auto-generated method stub
		return credRepo.findByEmail(email).isPresent();
	}

	@Override
	public Credential findByUsername(String username) {
		// TODO Auto-generated method stub
		return credRepo.findByUsername(username).orElse(null);
	}

	@Override
	public Credential findByEmail(String email) {
		// TODO Auto-generated method stub
		return credRepo.findByEmail(email).orElse(null);
	}

	@Override
	public Credential findByUserId(Long id) {
		// TODO Auto-generated method stub
		return credRepo.findById(id).orElse(null);
	}

	@Override
	public Credential findByPhone(String ph) {
		// TODO Auto-generated method stub
		return credRepo.findByPhNum(ph);
	}
}