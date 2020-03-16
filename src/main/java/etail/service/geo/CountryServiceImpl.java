package etail.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.repository.geo.CountryRepository;
import etail.repository.geo.StateRepository;

@Service
public class CountryServiceImpl implements CountryService{
	public CountryRepository countryRepo;
	public StateRepository stateRepo;

	public CountryServiceImpl(CountryRepository countryRepo, StateRepository stateRepo) {
		this.countryRepo = countryRepo;
		this.stateRepo = stateRepo;
	}
	
	public CountryServiceImpl() {
	}

	@Override
	public Country getCountryById(Long id) {
		return countryRepo.findById(id).orElse(null);
	}

	@Override
	public List<State> getCountryStates(Long id) {
		List<State> states = new ArrayList<>();
		this.stateRepo.findAll().forEach(x-> {
			if(x.getCountry().getId() == id)
				states.add(x);
		});
		
		return states;
	}

	@Override
	public void save(Country c) {
		countryRepo.save(c);
	}

	@Override
	public void deleteById(Long id) {
		countryRepo.deleteById(id);
	}

	@Override
	public void findById(Long id) {
		countryRepo.findById(id);
	}

	@Override
	public void delete(Country c) {
		countryRepo.delete(c);
	}
}
