package etail.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="USERPINFO")
public class UserPInfo implements UserInfo{
	@Id
	public Long id;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="userPInfo")
	@JoinColumn(name="FK_USER_ID")
	@MapsId
	public User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	@Column(name="")
	public String firstName;
	public String lastName;
	
	public String emailPrimary;
	public String phonePrimary;
	
	@NaturalId
	public String GIN;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String getEmailPrimary() {
		return emailPrimary;
	}

	public void setEmailPrimary(String emailPrimary) {
		this.emailPrimary = emailPrimary;
	}

	@Override
	public String getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhPrimary(String phPrimary) {
		this.phonePrimary = phPrimary;
	}

	public String getGIN() {
		return GIN;
	}

	public void setGIN(String gIN) {
		GIN = gIN;
	}

	public UserPInfo() {}
	
	
}