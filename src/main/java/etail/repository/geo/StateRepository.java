package etail.repository.geo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.geo.City;
import etail.domain.geo.State;

@Repository
public interface StateRepository extends CrudRepository<State,Long> {
	
	@Query(value="SELECT C.* FROM CITY C"
			+ "INNER JOIN STATE S ON S.ID = C.FK_CITY_ID"
			+ "WHERE S.ID = ?1", nativeQuery=true)
	@Transactional(readOnly=true)
	List<City> qfindFromStateCitiesById(Long id);
	List<State> findByCountry_Id(Long id);
}
