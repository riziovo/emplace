package etail.repository.geo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import etail.domain.geo.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {
}
