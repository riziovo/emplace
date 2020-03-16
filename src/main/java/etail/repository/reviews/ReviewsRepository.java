package etail.repository.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import etail.domain.reviews.Review;
import etail.domain.seller.Seller;
import etail.domain.user.User;

@Repository
public interface ReviewsRepository  extends CrudRepository<Review, Long>{
	
	@Transactional(readOnly=true)
	public List<Review> findBySeller(Seller s);
	public List<Review> findByUser(User u);
	
	public void deleteByUser_Id(Long id);
	
	@Query(value="DELETE * FROM REVIEWS WHERE REVIEW.FK_USER_ID = :id",nativeQuery=true)
	public void deleteReviewsOfUser(@Param("id")Long id);
	
	@Query(value="SELECT REVIEW.* FROM REVIEWS WHERE REVIEW.FK_USER_ID = :id", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<Review> findReviewsOfUser(@Param("id")Long id);

	@Query(value="SELECT REVIEW.* FROM REVIEWS WHERE REVIEW.FK_SELLER_ID = :id", nativeQuery=true)
	@Transactional(readOnly=true)
	public List<Review> findReviewsOnSeller(@Param("id")Long id);
}