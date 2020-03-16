package etail.service.geo;

import java.util.List;

import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;

public interface AreaService {
	void save(Area a);
	void delete(Area a);
	
	List<Area> findByCity_Id(Long id);
	List<Area> findByCity(City city);
	
	City findCityByArea(Area area);
	City findCityByArea_Id(Long id);
	
	Area findById(Long id);
	City findFromAreaCity(Long id);
	State findFromAreaState(Long id);
	Country findFromAreaCountry(Long id);
	
	List<Area> qfindByCityId(Long id);
	List<Area> qfindByCityName(String name);
}