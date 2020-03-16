package etail.repository.geo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.geo.City;
import etail.domain.geo.State;

@Repository
public interface CityRepository extends CrudRepository<City,Long> {
	public City findByNameAndState_Id(String name, Long id);
	public City findByNameAndState(String name, State s);
	
	public List<City> findByState_Id(Long id);
	
	@Query(value="SELECT C.* FROM CITY C WHERE C.FK_STATE_ID = :id", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<City> qfindByStateId(@Param("id")Long id);
	
	@Query(value="SELECT C.* FROM CITY C "
			+ "INNER JOIN STATE S ON S.ID = C.FK_STATE_ID"
			+ "WHERE S.NAME = :name", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<City> qfindByStateName(@Param("name")String name);

	@Query(value="SELECT C.* FROM CITY C"
			+ "INNER JOIN AREA A ON A.FK_CITY_ID = C.ID"
			+ "WHERE A.ID = :id"
			+ "LIMIT 1", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<City> qfindCityByAreaId(@Param("id")Long id);
	
	@Query(value="SELECT C.* FROM CITY C"
			+ "INNER JOIN AREA A ON A.FK_CITY_ID = C.ID"
			+ "WHERE A.NAME = :name"
			+ "LIMIT 1", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<City> qfindCityByAreaName(@Param("name")String name);
}