package etail.domain.reviews;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import etail.domain.seller.Seller;
import etail.domain.user.User;

@Entity
@Table(name="REVIEWS")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_USER_ID")
	public User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_SELLER_ID")
	public Seller seller;
	
	@Column(nullable = false)
	public String headline;
	
	@Column(name="TIMESTAMP", columnDefinition="DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date timestmp;
	
	public Review(User user, Seller seller, Date timestmp) {
		this.user = user;
		this.seller = seller;
		this.timestmp = timestmp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Date getTimestmp() {
		return timestmp;
	}

	public void setTimestmp(Date timestmp) {
		this.timestmp = timestmp;
	}

	public Review() {
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}	
}
