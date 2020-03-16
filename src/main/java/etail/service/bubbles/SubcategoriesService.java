package etail.service.bubbles;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import etail.domain.bubbles.Category;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.SellerHead;

public interface SubcategoriesService {
	public void saveAll(List<Subcategory> cats);
	public void delete(List<Subcategory> cats);
	
	
	public Subcategory findByName(String name);
	public Set<SellerHead> findBySubcategoryName(String name);
	public Set<SellerHead> findBySubcategoryId(Long id);
	
	public List<Subcategory> findSubcategoriesByCategoryId(Long id);
	public List<Subcategory> findSubcategoriesByCategoryName(String name);
	public List<Subcategory> findSubcategoriesByCategory(Category cat);
	
	public List<Subcategory> qsfindSubcategoriesByCategoryId(Long id);
	public List<Subcategory> qsfindSubcategoriesByCategoryName(String name);
}