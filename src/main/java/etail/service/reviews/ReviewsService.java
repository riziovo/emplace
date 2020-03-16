package etail.service.reviews;

import java.util.List;

import etail.domain.reviews.Review;
import etail.domain.seller.Seller;
import etail.domain.user.User;

public interface ReviewsService {
	public void save(Review r);
	
	public void deleteByUser_Id(Long id);
	public void qDeleteReviewsOfUser(Long id);
	
	public User findUserById(Long id);
	public Seller findSellerById(Long id);
	
	public List<Review> findBySeller(Seller s);
	public List<Review> findByUser(User u);
	
	public List<Review> findReviewsOfUser(Long id);
	public List<Review> findReviewsOnSeller(Long id);
}
