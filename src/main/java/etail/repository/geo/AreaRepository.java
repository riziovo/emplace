package etail.repository.geo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.geo.Area;
import etail.domain.geo.City;

@Repository
public interface AreaRepository extends CrudRepository<Area,Long> {
	List<Area> findByCity_Id(Long id);
	List<Area> findByCity(City city);
	
	@Query(value="SELECT A.* FROM AREA A WHERE A.FK_CITY_ID = :id", nativeQuery=true)
	@Transactional(readOnly=true)
	List<Area> qfindByCityId(@Param("id")Long id);
	
	@Query(value="SELECT A.* FROM AREA A"
			+ "JOIN CITY C ON A.FK_CITY_ID = C.ID"
			+ "WHERE C.NAME = :name", nativeQuery=true)
	@Transactional(readOnly=true)
	List<Area> qfindByCityName(@Param("name")String name);
}