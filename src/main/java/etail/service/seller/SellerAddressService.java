package etail.service.seller;

import java.util.List;

import etail.domain.seller.Seller;
import etail.domain.seller.SellerAddress;
import etail.domain.seller.SellerHead;

public interface SellerAddressService {
	void updateSellerAddressById(SellerAddress s);
	void saveSellerAddress(SellerAddress s);
	SellerAddress getSellerAddressById(Long id);
	List<SellerHead> getSellersByAreaId(Long id);
	List<SellerHead> getSellersByCityId(Long id);
}