package etail.service.bubbles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.bubbles.Category;
import etail.domain.bubbles.Subcategory;
import etail.domain.seller.SellerHead;
import etail.repository.bubbles.SubcategoriesRepository;

@Service
public class SubcategoriesServiceImpl implements SubcategoriesService{
	public SubcategoriesRepository subRepo;

	@Autowired
	public SubcategoriesServiceImpl(SubcategoriesRepository subRepo) {
		this.subRepo = subRepo;
	}

	@Override
	public List<Subcategory> findSubcategoriesByCategoryId(Long id) {
		// TODO Auto-generated method stub
		List<Subcategory> subList = new ArrayList<>();
		subRepo.findAll().forEach(x->{
			if(x.getCategory().getId().equals(id))
				subList.add(x);
		});
		
		return subList;
	}

	@Override
	public List<Subcategory> findSubcategoriesByCategory(Category cat) {
		List<Subcategory> subList = new ArrayList<>();
		subRepo.findByCategory(cat).forEach(subList::add);
		return subList;
	}

	@Override
	public Subcategory findByName(String name) {
		// TODO Auto-generated method stub
		return subRepo.findByName(name).orElse(null);
	}

	@Override
	public List<Subcategory> qsfindSubcategoriesByCategoryId(Long id) {
		// TODO Auto-generated method stub
		return subRepo.qfindSubcategoriesByCategoryId(id);
	}

	@Override
	public List<Subcategory> qsfindSubcategoriesByCategoryName(String name) {
		// TODO Auto-generated method stub
		return subRepo.qfindSubcategoriesByCategoryName(name);
	}

	@Override
	public List<Subcategory> findSubcategoriesByCategoryName(String name) {
		List<Subcategory> subList = new ArrayList<>();
		subRepo.findAll().forEach(x->{
			if(x.getCategory().getName().equals(name))
				subList.add(x);
		});
		
		return subList;
	}

	@Override
	public Set<SellerHead> findBySubcategoryName(String name) {
		// TODO Auto-generated method stub
		return subRepo.findByName(name).orElse(null).getSellers();
	}

	@Override
	public Set<SellerHead> findBySubcategoryId(Long id) {
		// TODO Auto-generated method stub
		return subRepo.findById(id).orElse(null).getSellers();
	}

	@Override
	public void saveAll(List<Subcategory> cats) {
		subRepo.saveAll(cats);
	}

	@Override
	public void delete(List<Subcategory> cats) {
		subRepo.saveAll(cats);
	}

}
