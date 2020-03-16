package etail.repository.seller;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.geo.Area;
import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.domain.seller.Seller;
import etail.domain.seller.SellerAddress;

@Repository
public interface SellerAddressRepository extends CrudRepository<SellerAddress,Long> {
	Collection<Seller> findByAreaIs(Area area);
}