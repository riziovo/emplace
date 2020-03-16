package etail.service.geo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.repository.geo.AreaRepository;
import etail.repository.geo.CityRepository;

@Service
public class CityServiceImpl implements CityService{
	public CityRepository cityRepo;
	public AreaRepository areaRepo;
	
	public CityServiceImpl(CityRepository cityRepo, AreaRepository areaRepo) {
		this.cityRepo = cityRepo;
		this.areaRepo = areaRepo;
	}

	@Override 
	public City findCityById(Long id) {
		return cityRepo.findById(id).orElse(null);
	}

	@Override
	public State findFromCityState(Long id) {
		return this.findCityById(id).getState();
	}

	@Override
	public Country findFromCityCountry(Long id) {
		// TODO Auto-generated method stub
		return this.findFromCityState(id).getCountry();
	}

	@Override
	public List<Area> findFromCityAreas(Long cityId) {
		List<Area> areas = new ArrayList<>();
		this.areaRepo.findAll().forEach(x-> {
			if(x.getCity().getId() == cityId)
				areas.add(x);
		});
		
		return areas;
	}

	@Override
	public List<City> findByState_Id(Long id) {
		// TODO Auto-generated method stub
		return cityRepo.findByState_Id(id);
	}

	@Override
	public List<City> qfindByStateId(Long id) {
		// TODO Auto-generated method stub
		return cityRepo.qfindByStateId(id);
	}

	@Override
	public List<City> qfindByStateName(String name) {
		// TODO Auto-generated method stub
		return cityRepo.qfindByStateName(name);
	}

	@Override
	public City qfindCityByAreaId(Long id) {
		List<City> c = cityRepo.qfindCityByAreaId(id);
		if(c.size() < 1) return null;
		
		return c.get(0);
	}

	@Override
	public City qfindCityByAreaName(String name) {
		List<City> c = cityRepo.qfindCityByAreaName(name);
		if(c.size() < 1) return null;
		
		return c.get(0);
	}

	@Override
	public void save(City c) {
		cityRepo.save(c);
	}

	@Override
	public void delete(City c) {
		cityRepo.delete(c);
	}

	@Override
	public City findByNameAndState_Id(String name, Long id) {
		// TODO Auto-generated method stub
		return cityRepo.findByNameAndState_Id(name, id);
	}

	@Override
	public City findByNameAndState(String name, State s) {
		// TODO Auto-generated method stub
		return cityRepo.findByNameAndState(name, s);
	}
}
