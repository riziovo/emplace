package etail.domain.bubbles;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import etail.domain.seller.SellerHead;

@Entity
@Table(name="SUBCATEGORIES")
public class Subcategory {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	
	@NaturalId
	@Column(nullable = false, unique = true, length=30)
	public String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="FK_CATEGORY_ID")
	public Category category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcategories")
	public Set<SellerHead> sellers = new HashSet<>();
	
	public Subcategory() {}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Subcategory))
			return false;

		Subcategory objS = (Subcategory) obj;
		return Objects.equals(hashCode(), objS.hashCode());
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<SellerHead> getSellers() {
		return sellers;
	}

	public void setSellers(Set<SellerHead> sellers) {
		this.sellers = sellers;
	}
	
	public void addSeller(SellerHead s) {
		s.subcategories.add(this);
		sellers.add(s);
	}
	
	public void removeSeller(SellerHead s) {
		s.subcategories.remove(this);
		this.sellers.remove(s);
	}
}
