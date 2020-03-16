package etail.service.geo;

import java.util.List;

import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;

public interface CityService {
	public void save(City c);
	public void delete(City c);
	
	public City findByNameAndState_Id(String name, Long id);
	public City findByNameAndState(String name, State s);
	
	City findCityById(Long id);
	State findFromCityState(Long id);
	Country findFromCityCountry(Long id);
	List<Area> findFromCityAreas(Long id);
	
	public List<City> findByState_Id(Long id);
	public List<City> qfindByStateId(Long id);
	public List<City> qfindByStateName(String name);
	public City qfindCityByAreaId(Long id);
	public City qfindCityByAreaName(String name);
}
