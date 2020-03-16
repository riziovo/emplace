package etail.repository.seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.seller.SellerBody;

@Repository
public interface SellerBodyRepository  extends CrudRepository<SellerBody, Long>{

}
