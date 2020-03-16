package etail.service.seller;

import etail.domain.seller.SellerBody;

public interface SellerBodyService {
	public boolean updateBody(SellerBody s);
	SellerBody findSellerById(Long id);
	void saveSellerBody(SellerBody s);
}