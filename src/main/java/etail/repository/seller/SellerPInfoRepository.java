package etail.repository.seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.seller.SellerPInfo;

@Repository
@Transactional(readOnly=true)
public interface SellerPInfoRepository  extends CrudRepository<SellerPInfo, Long>{
	public SellerPInfo findByEmailPrimary(String em);
	public SellerPInfo findByPhonePrimary(String em);
	public SellerPInfo findByGIN(String gin);
}