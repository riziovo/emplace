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

@Entity
@Table(name="STATE")
public class State  implements Geo{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="STATE_ID")
	public Long id;
	
	@Column(name="STATE_NAME")
	public String name;
	
	@ManyToOne(fetch = FetchType.EAGER,  cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="FK_COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
	public Country country;
	
	public State(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public State() {
		// TODO Auto-generated constructor stub
	}
}
