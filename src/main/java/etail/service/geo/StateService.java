package etail.service.geo;

import java.util.List;

import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;

public interface StateService {
	void deleteById(Long id);
	void save(State s);
	void delete(State s);
	State findById(Long id);
	Country findFromStateCountryById(Long id);
	List<City> findFromStateCitiesById(Long id);
	List<State> findByCountry_Id(Long id);
	
	List<City> qfindFromStateCitiesById(Long id);
}