package etail.repository.seller;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.SellerHead;

@Repository
@Transactional(readOnly=true)
public interface SellerHeadRepository  extends CrudRepository<SellerHead, Long>{
	
	public List<SellerHead> findByNameLike(String name);
	public Set<SellerHead> findByLabels_NameIn(List<String> labels);
	public Set<SellerHead> findBySubcategories_NameIn(List<String> labels);
	
	public List<SellerHead> findBySubcategoriesIn(List<Subcategory> subl);
	public List<SellerHead> findByLabelsIn(List<Label> labl);
	
	@Query(value="SELECT SS.M_SELLER_ID FROM SELLERS_SUBCATEGORIES SS WHERE SS.M_SUBCATEGORY_ID IN :ids", nativeQuery=true)
	public List<Long> lqfindAllSHIdsBySubcategoryIds(@Param("ids")List<Long> ids);
	
	@Query(value="SELECT SL.M_SELLER_ID FROM SELLERS_LABELS SL WHERE SL.M_LABEL_ID IN :ids", nativeQuery=true)
	public List<Long> lqfindAllSHIdsByLabelIds(@Param("ids")List<Long> ids);
	
	@Query(value="SELECT SH.ID FROM SELLERHEAD SH WHERE SH.FK_SUBCATEGORY_ID IN :ids", nativeQuery=true)
	public List<SellerHead> lqfindAllSellerHeadByIds(@Param("ids")List<Long> idS);
	
	@Query(value="SELECT SH.* FROM SELLERHEAD SH\r\n" + 
			"INNER JOIN SELLERS_SUBCATEGORIES SS ON SS.M_SELLER_ID = SH.ID\r\n" + 
			"WHERE SS.M_SUBCATEGORY_ID = :id", nativeQuery=true)
	public Collection<SellerHead> qFindBySubcategory(@Param("id")Long subcatId);
	
	@Query(value="SELECT SH.* FROM SELLERHEAD SH\r\n" + 
			"INNER JOIN SELLERS_LABELS SL ON SL.M_SELLER_ID = SH.ID\r\n" + 
			"WHERE SL.M_LABEL_ID = :id", nativeQuery=true)
	public Collection<SellerHead> qFindByLabel(@Param("id")Long subcatId);
	
	@Query(value="SELECT SH.* \r\n"+
			"FROM SELLERHEADS SH\r\n"+
			"INNER JOIN SELLERS_SUBCATEGORIES SS ON SS.M_SELLER_ID = SH.ID\r\n" + 
			"WHERE SS.M_SUBCATEGORY_ID = :catid AND SH.SH_CITY_ID = :cityid AND SH.NAME LIKE :query", nativeQuery=true)
	public Collection<SellerHead> qSearchByCity(@Param("catid")Long subcatId, @Param("cityid") Long cityId, @Param("query")String query);
	
	@Query(value="SELECT SH.* \r\n"+
			"FROM SELLERHEADS SH\r\n"+
			"INNER JOIN SELLERS_SUBCATEGORIES SS ON SS.M_SELLER_ID = SH.ID\r\n" + 
			"WHERE SS.M_SUBCATEGORY_ID = :catid AND SH.SH_STATE_ID = :stateid AND SH.NAME LIKE :query", nativeQuery=true)
	public Collection<SellerHead> qSearchByState(@Param("catid")Long subcatId, @Param("stateid") Long stateId, @Param("query")String query);

	@Query(value="SELECT SH.* \r\n"+
			"FROM SELLERHEADS SH\r\n"+
			"INNER JOIN SELLERS_SUBCATEGORIES SS ON SS.M_SELLER_ID = SH.ID\r\n" + 
			"WHERE SS.M_SUBCATEGORY_ID = :catid AND SH.SH_AREA_ID = :areaid AND SH.NAME LIKE :query", nativeQuery=true)
	public Collection<SellerHead> qSearchByArea(@Param("catid")Long subcatId, @Param("areaid") Long areaId, @Param("query")String query);
	
}