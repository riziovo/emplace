package etail.service.user;

import etail.domain.user.User;

public interface UserService {
	public User findById(Long id);
	public void save(User u);
	public void delete(User u);
	public User findUserByPhonePrime(String ph);
	public User findUserByEmailPrime(String em);
	public User findByGIN(String gin);
}