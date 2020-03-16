package etail.repository.bubbles;

import java.util.Optional;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.bubbles.Category;

@Repository
public interface CategoriesRepository  extends CrudRepository<Category, Long>{
	@Transactional(readOnly=true)
	public Optional<Category> findByName(String name);
}