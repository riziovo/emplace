package etail.service.reviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etail.domain.reviews.Review;
import etail.domain.seller.Seller;
import etail.domain.user.User;
import etail.repository.reviews.ReviewsRepository;

@Service
public class ReviewsServiceImpl implements ReviewsService{
	private ReviewsRepository revRepo;

	@Autowired
	public ReviewsRepository getRevRepo() {
		return revRepo;
	}

	public void setRevRepo(ReviewsRepository revRepo) {
		this.revRepo = revRepo;
	}

	@Override
	public List<Review> findBySeller(Seller s) {
		// TODO Auto-generated method stub
		return revRepo.findBySeller(s);
	}

	@Override
	public void save(Review r) {
		revRepo.save(r);
	}

	@Override
	public List<Review> findByUser(User u) {
		// TODO Auto-generated method stub
		return revRepo.findByUser(u);
	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return revRepo.findById(id).get().getUser();
	}

	@Override
	public Seller findSellerById(Long id) {
		return revRepo.findById(id).get().getSeller();
	}

	@Override
	public List<Review> findReviewsOfUser(Long id) {
		// TODO Auto-generated method stub
		return revRepo.findReviewsOfUser(id);
	}

	@Override
	public List<Review> findReviewsOnSeller(Long id) {
		// TODO Auto-generated method stub
		return revRepo.findReviewsOnSeller(id);
	}

	@Override
	public void deleteByUser_Id(Long id) {
		revRepo.deleteByUser_Id(id);
	}

	@Override
	public void qDeleteReviewsOfUser(Long id) {
		revRepo.deleteReviewsOfUser(id);
	}
}
