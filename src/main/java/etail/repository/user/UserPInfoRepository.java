package etail.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.user.UserPInfo;

@Repository
public interface UserPInfoRepository  extends CrudRepository<UserPInfo, Long>{
	
	@Transactional(readOnly=true)
	public UserPInfo findByEmailPrimary(String email);
	
	@Transactional(readOnly=true)
	public UserPInfo findByPhonePrimary(String phone);
	
	@Transactional(readOnly=true)
	public UserPInfo findByGIN(String gin);
}