package etail.service.user;

import etail.domain.user.UserPInfo;

public interface UserPInfoService {
	public void save(UserPInfo uip);
	public UserPInfo findByEmailPrimary(String email);
	public UserPInfo findByPhonePrimary(String phone);
	public UserPInfo findByGIN(String gin);
}