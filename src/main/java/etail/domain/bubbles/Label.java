package etail.domain.bubbles;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import etail.domain.seller.SellerHead;

@Entity
@Table(name="Labels")
public class Label {

	@Id
	@GeneratedValue
	public Long id;
	
	@NaturalId
	@Column(nullable=false, unique = true, length = 50)
	public String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="FK_PARENT_ID", nullable=true)
	public Label parent;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "labels")
	public Set<SellerHead> sellers = new HashSet<>();
	
	public Label() {}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Label))
			return false;

		Label objL = (Label) obj;
		return Objects.equals(hashCode(), objL.hashCode());
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

	public Set<SellerHead> getSellers() {
		return sellers;
	}

	public void setSellers(Set<SellerHead> sellers) {
		this.sellers = sellers;
	}
	
	public void addSeller(SellerHead seller) {
		seller.labels.add(this);
		this.sellers.add(seller);
	}
	
	public void removeSeller(SellerHead seller) {
		seller.labels.remove(this);
		this.sellers.remove(seller);
	}
}
