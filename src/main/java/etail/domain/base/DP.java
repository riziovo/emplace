package etail.domain.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="DP")
public class DP {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="DP_ID", updatable=false)
	public Long id;
	
	@Column(name="PLACEHOLDER")
	public String dpPlaceholder;
	
	@Lob
	@Column(name="BIG_DP", columnDefinition="BLOB")
	public Byte[] bigDP;
	
	@Lob
	@Column(name="TINY_DP", columnDefinition="BLOB")
	public Byte[] tinyDP;
	
	public DP() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte[] getBigDP() {
		return bigDP;
	}

	public void setBigDP(Byte[] bigDP) {
		this.bigDP = bigDP;
	}

	public Byte[] getTinyDP() {
		return tinyDP;
	}

	public void setTinyDP(Byte[] tinyDP) {
		this.tinyDP = tinyDP;
	}
}
