package etail.service.geo;

import java.util.List;

import etail.domain.geo.Country;
import etail.domain.geo.State;

public interface CountryService {
	void save(Country c);
	void deleteById(Long id);
	void findById(Long id);
	void delete(Country c);
	
	Country getCountryById(Long id);
	List<State> getCountryStates(Long id);
}
