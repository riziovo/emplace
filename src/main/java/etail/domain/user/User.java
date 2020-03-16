package etail.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import etail.domain.account.Credential;

@Entity
@Table(name="USER")
public class User implements UserEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Long id;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public UserPInfo userPInfo;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="user")
	@JoinColumn(name="FK_CREDENTIAL_ID")
	private Credential credential;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserPInfo getUserPInfo() {
		return userPInfo;
	}

	public void setUserPInfo(UserPInfo userPInfo) {
		this.userPInfo = userPInfo;
	}

	public User() {}

	@Override
	public String getUserInfo() {
		// TODO Auto-generated method stub
		return getUserInfo();
	}
	
	
}