package etail.service.geo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.Country;
import etail.domain.geo.State;
import etail.repository.geo.AreaRepository;

@Service
public class AreaServiceImpl implements AreaService{
	public AreaRepository areaRepo;
	
	@Autowired
	public AreaServiceImpl(AreaRepository areaRepo) {
		this.areaRepo = areaRepo;
	}
	
	public AreaServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Area findById(Long id) {
		return areaRepo.findById(id).orElse(null);
	}

	@Override
	public State findFromAreaState(Long id) {
		return this.findFromAreaCity(id).getState();
	}

	@Override
	public Country findFromAreaCountry(Long id) {
		return this.findFromAreaState(id).getCountry();
	}

	@Override
	public City findFromAreaCity(Long id) {
		return this.findById(id).getCity();
	}

	@Override
	public void save(Area a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Area a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Area> findByCity_Id(Long id) {
		// TODO Auto-generated method stub
		return areaRepo.findByCity_Id(id);
	}

	@Override
	public List<Area> findByCity(City city) {
		// TODO Auto-generated method stub
		return areaRepo.findByCity(city);
	}

	@Override
	public City findCityByArea(Area area) {
		// TODO Auto-generated method stub
		return areaRepo.findById(area.getId()).orElse(null).getCity();
	}

	@Override
	public City findCityByArea_Id(Long id) {
		// TODO Auto-generated method stub
		return areaRepo.findById(id).orElse(null).getCity();
	}

	@Override
	public List<Area> qfindByCityId(Long id) {
		// TODO Auto-generated method stub
		return areaRepo.qfindByCityId(id);
	}

	@Override
	public List<Area> qfindByCityName(String name) {
		// TODO Auto-generated method stub
		return areaRepo.qfindByCityName(name);
	}
}