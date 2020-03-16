package etail.service.account;

import etail.domain.account.Credential;

public interface CredentialService {
	public Credential findByUserId(Long id);
	public boolean verifyAccountByUsername(String uname);
	public boolean recoverAccountByUsername(String uname);
	public boolean recoverAccountByEmail(String uname);
	public boolean verifyAccountByEmail(String email);
	public Credential findByUsername(String username);
	public Credential findByEmail(String email);
	public Credential findByPhone(String ph);
}