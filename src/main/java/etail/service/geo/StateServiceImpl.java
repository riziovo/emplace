package etail.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.repository.geo.CityRepository;
import etail.repository.geo.StateRepository;

@Service
public class StateServiceImpl implements StateService{
	public StateRepository stateRepo;
	public CityRepository cityRepo;
	
	public StateServiceImpl(StateRepository stateRepo, CityRepository cityRepo) {
		this.stateRepo = stateRepo;
		this.cityRepo = cityRepo;
	}
	
	public StateServiceImpl() {}

	@Override
	public State findById(Long id) {
		return this.stateRepo.findById(id).orElse(null);
	}

	@Override
	public Country findFromStateCountryById(Long id) {
		return this.findById(id).getCountry();
	}

	@Override
	public List<City> findFromStateCitiesById(Long id) {
		List<City> cities = new ArrayList<>();
		this.cityRepo.findAll().forEach(x-> {
			if(x.getState().getId() == id)
				cities.add(x);
		});
		return cities;
	}

	@Override
	public void deleteById(Long id) {
		stateRepo.deleteById(id);
	}

	@Override
	public void save(State s) {
		stateRepo.save(s);
	}

	@Override
	public void delete(State s) {
		stateRepo.delete(s);
	}

	@Override
	public List<State> findByCountry_Id(Long id) {
		// TODO Auto-generated method stub
		return stateRepo.findByCountry_Id(id);
	}

	@Override
	public List<City> qfindFromStateCitiesById(Long id) {
		// TODO Auto-generated method stub
		return stateRepo.qfindFromStateCitiesById(id);
	}
}