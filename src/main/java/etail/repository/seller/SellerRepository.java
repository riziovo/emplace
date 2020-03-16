package etail.repository.seller;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.seller.Seller;

@Repository
@Transactional(readOnly=true)
public interface SellerRepository extends CrudRepository<Seller,Long> {
	@Query(value="SELECT SELLER.* FROM SELLER\r\n" + 
			"INNER JOIN SELLER_ADDRESS ON SELLER_ADDRESS.SELLER_SELLER_ID = SELLER.SELLER_ID\r\n" + 
			"INNER JOIN AREA ON SELLER_ADDRESS.FK_AREA_ID = AREA.AREA_ID\r\n" + 
			"WHERE AREA.AREA_ID = :areaID", nativeQuery=true)
	Collection<Seller> findAllSellersByArea(@Param("areaID")Long id);
	
	@Query(value="SELECT SELLER.* FROM SELLER\r\n" + 
			"INNER JOIN SELLER_ADDRESS ON SELLER_ADDRESS.SELLER_SELLER_ID = SELLER.SELLER_ID\r\n" + 
			"INNER JOIN AREA ON SELLER_ADDRESS.FK_AREA_ID = AREA.AREA_ID\r\n" + 
			"INNER JOIN CITY ON CITY.CITY_ID = AREA.FK_CITY_ID\r\n" + 
			"WHERE CITY.CITY_ID = :cityID", nativeQuery=true)
	Collection<Seller> findAllSellersByCity(@Param("cityID")Long id);
}