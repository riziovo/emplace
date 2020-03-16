package etail.domain.seller;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import etail.domain.base.Body;

@DynamicUpdate
@Entity
@Table(name="SELLERBODY")
public class SellerBody implements Body{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SELLERBODY_ID", updatable=false)
	public Long id;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="sellerBody")
	@JoinColumn(name="FK_SELLER_ID", updatable=false)
	@MapsId
	@JsonIgnore
	public Seller seller;
	
	@Column(name="BODYDESC")
	public String bodyDesc;
	
	@Column(name="HOURS")
	public String bodyHours;

	public SellerBody() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public String getBodyDesc() {
		return bodyDesc;
	}

	public void setBodyDesc(String bodyDesc) {
		this.bodyDesc = bodyDesc;
	}

	public String getBodyHours() {
		return bodyHours;
	}

	public void setBodyHours(String bodyHours) {
		this.bodyHours = bodyHours;
	}
}