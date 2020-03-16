package etail.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.base.DP;

@Repository
public interface DPRepository  extends CrudRepository<DP, Long>{

}
