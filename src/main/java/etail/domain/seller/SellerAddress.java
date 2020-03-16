package etail.domain.seller;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import etail.domain.geo.Area;

@Entity
@Table(name="SELLERADDRESS")
public class SellerAddress {
	
	@Id
	public Long id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy="sellerAddress")
	@MapsId
	@JsonIgnore
	public SellerHead seller;

	@NotNull
	public String addressLine1;
	public String addressLine2;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name="FK_AREA_ID")
	public Area area;
	
	public SellerHead getSellerHead() {
		return seller;
	}
	
	public void setSellerHead(SellerHead seller) {
		this.seller = seller;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public SellerAddress() {
		// TODO Auto-generated constructor stub
	}
}
