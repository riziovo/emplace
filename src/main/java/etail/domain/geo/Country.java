package etail.domain.geo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country  implements Geo{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="COUNTRY_ID")
	public Long id;
	
	@Column(name="COUNTRY_NAME", length= 30, nullable=false)
	public String name;
	
	public Country(String name) {
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

	public Country() {
		// TODO Auto-generated constructor stub
	}

}
