package etail.service.bubbles;

import java.util.List;

import etail.domain.bubbles.Category;

public interface CategoriesService {
	public void save(Category cat);
	public void saveAll(List<Category> cats);
	public void delete(List<Category> cats);
	
	public List<Category> getAllCategories();
	public Category findById(Long id);
}