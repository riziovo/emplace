package etail.domain.account;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import etail.domain.user.User;

@Entity
@Table(name="CREDENTIALS")
public class Credential {
	@Id
	public Long id;
	
	@NaturalId
	@Column(unique= true)
	public String username;
	
	@NaturalId
	public String phNum;
	
	@NaturalId
	public String email;
	
	public String password;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_USER_ID")
	public User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_ROLE_NAME", referencedColumnName="ROLE")
	public AccountType role;

	public AccountType getRole() {
		return role;
	}

	public void setRole(AccountType role) {
		this.role = role;
	}

	public Credential() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhNum() {
		return phNum;
	}

	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
