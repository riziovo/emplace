package etail.service.seller;

import etail.domain.seller.SellerPInfo;

public interface SellerPInfoService {
	public SellerPInfo findByEmailPrimary(String em);
	public SellerPInfo findByPhonePrimary(String em);
	public SellerPInfo findByGIN(String gin);
}