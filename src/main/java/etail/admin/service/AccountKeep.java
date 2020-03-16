package etail.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.account.Credential;
import etail.service.account.CredentialService;
import etail.service.seller.SellerService;
import etail.service.user.UserService;

@Service
public class AccountKeep {
	SellerService ss;
	UserService us;
	CredentialService cs;
	
	@Autowired
	public AccountKeep(SellerService ss, UserService us, CredentialService cs) {
		this.ss = ss;
		this.us = us;
		this.cs = cs;
	}

	public String getAccountCredOfUserById(Long id) {
		return cs.findByUserId(id).getRole().getRole();
	}
	
	public void deleteSellerAccount(Long id) {
		ss.deleteSellerById(id);
	}
	
	public Long signinValidate(String uname, String pass) {
		Credential cred = cs.findByUsername(uname);
		if(cred == null)
			return -1L;
		
		return cred.getPassword().equals(pass) ? cred.getId() : -2L;
	}
	
	public String registerValidate(Credential c) {
		StringBuilder sb = new StringBuilder();

		if(cs.findByUsername(c.getUsername()) != null)
			sb.append("0,");
		else
			sb.append("1,");
		
		if(cs.findByEmail(c.getEmail()) != null)
			sb.append("0,");
		else
			sb.append("1");
		
		if(cs.findByPhone(c.getPhNum()) != null)
			sb.append("0,");
		else
			sb.append("1");

		return sb.toString();
	}
}