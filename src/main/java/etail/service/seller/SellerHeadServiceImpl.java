package etail.service.seller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.base.DP;
import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.State;
import etail.domain.seller.SellerHead;
import etail.repository.base.DPRepository;
import etail.repository.seller.SellerHeadRepository;

@Service
public class SellerHeadServiceImpl implements SellerHeadService{
	private SellerHeadRepository shRepo;
	private DPRepository dpRepo;
	public DPRepository getDpRepo() {
		return dpRepo;
	}

	@Autowired
	public void setDpRepo(DPRepository dpRepo) {
		this.dpRepo = dpRepo;
	}

	@Autowired
	public SellerHeadServiceImpl(SellerHeadRepository shRepo) {
		this.shRepo = shRepo;
	}

	@Override
	public boolean updateHeadInfo(SellerHead s) {
		SellerHead ent = shRepo.findById(s.getId()).orElse(null);
		if(ent == null) return false;
		ent.setName(s.getName());
		ent.setAbout(s.getAbout());
		shRepo.save(ent);
		return true;
	}

	@Override
	public List<SellerHead> findByNameLike(String name) {
		List<SellerHead> shl = shRepo.findByNameLike(name);
		return shl;
	}

	@Override
	public boolean updateHeadDP(SellerHead s) {
		dpRepo.deleteById(s.getDp().getId());
		DP newDp = dpRepo.save(s.getDp());
		
		SellerHead ent = shRepo.findById(s.getId()).get();
		ent.setDp(newDp);
		shRepo.save(ent);
		
		return true;
	}

	@Override
	public boolean updateHeadCat(SellerHead s) {
		SellerHead ent = shRepo.findById(s.getId()).orElse(null);
		if(ent == null) return false;
		ent.setSubcategories(s.getSubcategories());
		shRepo.save(ent);
		return true;
	}

	@Override
	public boolean updateHeadLabels(SellerHead s) {
		SellerHead ent = shRepo.findById(s.getId()).orElse(null);
		if(ent == null) return false;
		ent.setLabels(s.getLabels());
		shRepo.save(ent);
		return true;
	}

	@Override
	public List<SellerHead> findByLabelsLike(List<Label> labels) {
		List<SellerHead> shl = new ArrayList<>();
		shRepo.findAll().iterator().forEachRemaining(x->{
			for(Label l:labels)
			{
				if(x.getLabels().contains(l))
					shl.add(x);
			}
		});
		
		return shl;
	}

	@Override
	public List<SellerHead> findBySubcategoriesLike(List<Subcategory> subcats) {
		List<SellerHead> shl = new ArrayList<>();
		shRepo.findAll().iterator().forEachRemaining(x->{
			for(Subcategory s:subcats)
			{
				if(x.getSubcategories().contains(s))
					shl.add(x);
			}
		});
		
		return shl;
	}

	@Override
	public List<SellerHead> qsfindBySubcategory(Long id) {
		List<SellerHead> shl = new ArrayList<>();
		shRepo.qFindBySubcategory(id).forEach(shl::add);
		
		return shl;
	}

	@Override
	public List<SellerHead> qsfindByLabel(Long id) {
		List<SellerHead> shl = new ArrayList<>();
		shRepo.qFindByLabel(id).forEach(shl::add);
		
		return shl;
	}

	@Override
	public List<SellerHead> crudfindBySubcategories(List<Subcategory> subcats) {
		return shRepo.findBySubcategoriesIn(subcats);
	}

	@Override
	public List<SellerHead> crudfindByLabels(List<Label> labels) {
		return shRepo.findByLabelsIn(labels);
	}

	@Override
	public List<Long> lqFindShIdsBySubcatIds(List<Long> ids) {
		return shRepo.lqfindAllSHIdsBySubcategoryIds(ids);
	}

	@Override
	public List<Long> lqFindShIdsByLabelIds(List<Long> ids) {
		return shRepo.lqfindAllSHIdsByLabelIds(ids);
	}

	@Override
	public List<SellerHead> findSellerHeadsByShIds(List<Long> ids) {
		return shRepo.lqfindAllSellerHeadByIds(ids);
	}

	@Override
	public List<SellerHead> fetchAll() {
		List<SellerHead> sh = new ArrayList<>();
		shRepo.findAll().forEach(x->sh.add(x));
		return sh;
	}

	@Override
	public List<SellerHead> SearchByCity(Subcategory subcat, City city, String query) {
		
		List<SellerHead> shl = new ArrayList<>();
		shRepo.findAll().forEach(x->{
			if(x.getSubcategories().contains(subcat) & x.getCity().equals(city)
					& x.getName().contains(query))
				shl.add(x);
		});
		return shl;
	}

	@Override
	public List<SellerHead> SearchByArea(Subcategory subcat, Area area, String query) {
		
		List<SellerHead> shl = new ArrayList<>();
		shRepo.findAll().forEach(x->{
			if(x.getSubcategories().contains(subcat) & x.getArea().equals(area)
					& x.getName().contains(query))
				shl.add(x);
		});
		return shl;
	}

	@Override
	public List<SellerHead> SearchByState(Subcategory subcat, State state, String query) {
		
		List<SellerHead> shl = new ArrayList<>();
		shRepo.findAll().forEach(x->{
			if(x.getSubcategories().contains(subcat) & x.getState().equals(state) & x.getName().contains(query))
				shl.add(x);
		});
		return shl;
	}
	
	@Override
	public List<SellerHead> qSearchByArea(Long subcatId, Long areaId, String query) {
		List<SellerHead> shl = new ArrayList<>(shRepo.qSearchByArea(subcatId, areaId, query));
		return shl;
	}

	@Override
	public List<SellerHead> qSearchByCity(Long subcatId, Long cityId, String query) {
		List<SellerHead> shl = new ArrayList<>(shRepo.qSearchByCity(subcatId, cityId, query));
		return shl;
	}

	@Override
	public List<SellerHead> qSearchByState(Long subcatId, Long stateId, String query) {
		List<SellerHead> shl = new ArrayList<>(shRepo.qSearchByState(subcatId, stateId, query));
		return shl;
	}
	
}
