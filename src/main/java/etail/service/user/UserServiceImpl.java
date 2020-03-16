package etail.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.user.User;
import etail.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository uRepo;
	private UserPInfoService uipServ;
	
	@Autowired
	public UserServiceImpl(UserRepository uRepo, UserPInfoService uipServ) {
		this.uRepo = uRepo;
		this.uipServ = uipServ;
	}

	@Override
	public void save(User u) {
		uRepo.save(u);
	}

	@Override
	public void delete(User u) {
		uRepo.delete(u);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return uRepo.findById(id).orElse(null);
	}

	@Override
	public User findUserByPhonePrime(String ph) {
		// TODO Auto-generated method stub
		return uipServ.findByPhonePrimary(ph).getUser();
	}

	@Override
	public User findUserByEmailPrime(String em) {
		// TODO Auto-generated method stub
		return uipServ.findByEmailPrimary(em).getUser();
	}

	@Override
	public User findByGIN(String gin) {
		// TODO Auto-generated method stub
		return uipServ.findByGIN(gin).getUser();
	}
}
