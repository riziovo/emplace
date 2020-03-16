package etail.domain.geo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

//@Entity
//@Table(name="GeoAddress")
public class GeoAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	
	@JoinColumn(name="AFK_AREA_ID", referencedColumnName= "AREA_ID")
	public Area area;
	
	@JoinColumn(name="AFK_CITY_ID", referencedColumnName= "CITY_ID")
	public City city;
	
	@JoinColumn(name="AFK_STATE_ID", referencedColumnName= "STATE_ID")
	public State state;
	
	@JoinColumn(name="AFK_COUNTRY_ID", referencedColumnName= "COUNTRY_ID")
	public Country country;

	public GeoAddress() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}