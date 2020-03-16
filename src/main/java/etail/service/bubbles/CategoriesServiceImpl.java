package etail.service.bubbles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.bubbles.Category;
import etail.repository.bubbles.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService{
	public CategoriesRepository catRepo;
	
	@Autowired
	public CategoriesServiceImpl(CategoriesRepository catRepo) {
		this.catRepo = catRepo;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> catList = new ArrayList<>();
		catRepo.findAll().forEach(catList::add);
		return catList;
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return catRepo.findById(id).orElse(null);
	}

	@Override
	public void saveAll(List<Category> cats) {
		catRepo.saveAll(cats);
	}

	@Override
	public void delete(List<Category> cats) {
		catRepo.deleteAll(cats);	
	}

	@Override
	public void save(Category cat) {
		catRepo.save(cat);
	}
}