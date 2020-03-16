package etail.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.user.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
}