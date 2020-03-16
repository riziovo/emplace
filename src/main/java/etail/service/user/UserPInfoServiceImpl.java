package etail.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.user.UserPInfo;
import etail.repository.user.UserPInfoRepository;

@Service
public class UserPInfoServiceImpl implements UserPInfoService{
	private UserPInfoRepository uipRepo;
	
	@Autowired
	public UserPInfoServiceImpl(UserPInfoRepository uipRepo) {
		this.uipRepo = uipRepo;
	}

	@Override
	public void save(UserPInfo uip) {
		uipRepo.save(uip);
	}
	
	@Override
	public UserPInfo findByGIN(String gin) {
		return uipRepo.findByGIN(gin);
	}

	@Override
	public UserPInfo findByEmailPrimary(String email) {
		// TODO Auto-generated method stub
		return uipRepo.findByEmailPrimary(email);
	}

	@Override
	public UserPInfo findByPhonePrimary(String phone) {
		// TODO Auto-generated method stub
		return uipRepo.findByPhonePrimary(phone);
	}
}
