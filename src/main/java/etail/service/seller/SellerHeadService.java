package etail.service.seller;

import java.util.List;

import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.State;
import etail.domain.seller.SellerHead;

public interface SellerHeadService {
	public List<SellerHead> fetchAll();
	public boolean updateHeadInfo(SellerHead s);
	public boolean updateHeadDP(SellerHead s);
	public boolean updateHeadCat(SellerHead s);
	public boolean updateHeadLabels(SellerHead s);
	public List<SellerHead> findByNameLike(String name);
	public List<SellerHead> findByLabelsLike(List<Label> labels);
	public List<SellerHead> findBySubcategoriesLike(List<Subcategory> subcats);
	
	public List<SellerHead> crudfindBySubcategories(List<Subcategory> id);
	public List<SellerHead> crudfindByLabels(List<Label> id);
	
	public List<SellerHead> qsfindBySubcategory(Long id);
	public List<SellerHead> qsfindByLabel(Long id);
	
	public List<Long> lqFindShIdsBySubcatIds(List<Long> ids);
	public List<Long> lqFindShIdsByLabelIds(List<Long> ids);
	public List<SellerHead> findSellerHeadsByShIds(List<Long> ids);
	
	public List<SellerHead> qSearchByArea(Long subcatId,Long areaId,String query);
	public List<SellerHead> qSearchByCity(Long subcatId,Long cityId,String query);
	public List<SellerHead> qSearchByState(Long subcatId,Long stateId,String query);
	
	public List<SellerHead> SearchByCity(Subcategory subcat,City city,String query);
	public List<SellerHead> SearchByArea(Subcategory subcat, Area area, String query);
	public List<SellerHead> SearchByState(Subcategory subcat, State state, String query);
}