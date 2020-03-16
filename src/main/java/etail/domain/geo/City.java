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
@Table(name="CITY")
public class City  implements Geo{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="CITY_ID")
	public Long id;
	
	@Column(name="CITY_NAME", length= 30, nullable=false)
	public String name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="FK_STATE_ID", referencedColumnName= "STATE_ID")
	public State state;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City(String name) {
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

	public City() {
		// TODO Auto-generated constructor stub
	}
}