package etail.repository.bubbles;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.bubbles.Category;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.SellerHead;

@Repository
@Transactional(readOnly=true)
public interface SubcategoriesRepository  extends CrudRepository<Subcategory, Long>{
	public Optional<Subcategory> findByName(String name);
	public List<Subcategory> findByCategory(Category cat);
	//public Subcategory findBySimpleNaturalId(String name);

	@Query(value="SELECT SUBCATEGORIES.*, COUNT(SS.M_SELLER_ID) FROM SELLERS_SUBCATEGORIES SS, SUBCATEGORIES"
			+ "INNER JOIN SUBCATEGORIES SUB ON SUB.ID = SS.M_SUBCATEGORY_ID"
			+ "INNER JOIN CATEGORIES CAT ON CAT.ID = SUB.FK_CATEGORY_ID"
			+ "WHERE SS.M_SUBCATEGORY_ID = :id", nativeQuery=true)
	public Map<Subcategory, Integer> qfindSubcategoriesWithCount(@Param("id")Long id);
	
	@Query(value="SELECT SUBCATEGORIES.* FROM SUBCATEGORIES SUB WHERE SUB.FK_CATEGORY_ID = :id", nativeQuery=true)
	public List<Subcategory> qfindSubcategoriesByCategoryId(@Param("id")Long id);
	
	@Query(value="SELECT SUBCATEGORIES.* FROM SUBCATEGORIES SUB"
			+ "INNER JOIN CATEGORIES CAT ON CAT.ID = SUB.FK_CATEGORY_ID"
			+ "WHERE CATEGORIES.NAME = :name", nativeQuery=true)
	public List<Subcategory> qfindSubcategoriesByCategoryName(@Param("name")String name);
}