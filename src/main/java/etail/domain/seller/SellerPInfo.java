package etail.domain.seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="SELLERPINFO")
public class SellerPInfo implements SellerInfo{
	@Id
	public Long id;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="sellerPInfo")
	@JoinColumn(name="FK_SELLER_ID")
	@MapsId
	public Seller seller;
	
	@Column(name="FIRSTNAME")
	public String firstName;
	@Column(name="LASTNAME")
	public String lastName;
	
	@Column(name="EMAILPRIMARY")
	public String emailPrimary;
	@Column(name="PHONEPRMARY")
	public String phonePrimary;
	
	@NaturalId
	@Column(nullable=true)
	public String GST;
	
	@NaturalId
	@Column(nullable=true)
	public String GIN;
	
	public SellerPInfo() {}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailPrimary() {
		return emailPrimary;
	}

	public void setEmailPrimary(String emailPrimary) {
		this.emailPrimary = emailPrimary;
	}

	public String getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	public String getGST() {
		return GST;
	}

	public void setGST(String gST) {
		GST = gST;
	}

	public String getGIN() {
		return GIN;
	}

	public void setGIN(String gIN) {
		GIN = gIN;
	}

}