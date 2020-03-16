package etail.domain.seller;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;

import etail.domain.base.BaseEntity;
import etail.domain.base.DP;
import etail.domain.bubbles.Label;
import etail.domain.bubbles.Subcategory;
import etail.domain.geo.Area;
import etail.domain.geo.City;
import etail.domain.geo.State;

@DynamicUpdate
@Entity
@Table(name="SELLERHEAD")
public class SellerHead implements BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SELLER_ID", updatable=false)
	public Long id;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="sellerHead")
	@JoinColumn(name="FK_SELLER_ID", updatable=false)
	@MapsId
	@JsonIgnore
	public Seller seller;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_SELLER_ADDRESS", nullable=false)
//	@JsonIgnore
	public SellerAddress sellerAddress;
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Column(name="NAME", length= 30, nullable=false)
	public String name;
	
	@Column(name="ABOUT")
	public String about;
	
	@Range(min=0, max=5)
	@Column(name="STARS")
	public double stars;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SH_AREA_ID", referencedColumnName="AREA_ID", nullable = true)
	public Area area;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SH_CITY_ID", referencedColumnName="CITY_ID", nullable = true)
	public City city;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SH_STATE_ID", referencedColumnName="STATE_ID", nullable = true)
	public State state;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_DP_ID", referencedColumnName="DP_ID", nullable = true)
	@JsonIgnore
	public DP dp;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="SELLERS_SUBCATEGORIES",
		joinColumns = @JoinColumn(name="M_SELLER_ID"),
		inverseJoinColumns = @JoinColumn(name="M_SUBCATEGORY_ID")
	)
	public Set<Subcategory> subcategories = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name ="SELLERS_LABELS",
		joinColumns = @JoinColumn(name="M_SELLER_ID"),
		inverseJoinColumns = @JoinColumn(name="M_LABELS_ID")
			)
	public Set<Label> labels = new HashSet<>();

	public SellerHead() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public DP getDp() {
		return dp;
	}

	public void setDp(DP dp) {
		this.dp = dp;
	}

	public Set<Subcategory> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Set<Subcategory> subcategories) {
		for(Subcategory x: subcategories) {
			x.removeSeller(this);
		}
		this.subcategories = subcategories;
	}

	public Set<Label> getLabels() {
		return labels;
	}

	public void setLabels(Set<Label> labels) {
		for(Label x: labels) {
			x.removeSeller(this);
		}
		this.labels = labels;
	}
	
	public void removeLabel(Label s) {
		s.getSellers().remove(this);
		this.labels.remove(s);
	}
	
	public void addLabel(Label s) {
		this.labels.add(s);
	}
	
	public void removeSubcategory(Subcategory s) {
		s.getSellers().remove(this);
		this.subcategories.remove(s);
	}
	
	public void addSubcategory(Subcategory s) {
		this.subcategories.add(s);
	}

	public SellerAddress getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(SellerAddress sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}