package etail.service.seller;

import java.util.List;

import etail.domain.seller.Seller;
import etail.domain.seller.SellerBody;
import etail.domain.seller.SellerHead;

public interface SellerService {
	Seller findSellerById(Long id);
	void saveSeller(Seller s);
	void deleteSellerById(Long id);
	SellerHead findSellerHeadById(Long id);
	SellerBody findSellerBodyById(Long id);
	List<Seller> findSellerByName(String name);
	List<Seller> getAllSellers();
	List<SellerHead> getSellersByAreaId(Long id);
	List<SellerHead> getSellersByCityId(Long id);
	List<Seller> getSellerByQueryArea(Long id);
	List<Seller> getSellerByQueryCity(Long id);
}