package etail.domain.geo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="AREA")
public class Area implements Geo{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="AREA_ID")
	public Long id;
	
	@Column(name="AREA_NAME", length= 30, nullable=false)
	public String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="FK_CITY_ID", referencedColumnName="CITY_ID")
	public City city;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Area() {
		// TODO Auto-generated constructor stub
	}
}