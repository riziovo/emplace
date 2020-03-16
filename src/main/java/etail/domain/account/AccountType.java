package etail.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class AccountType implements Account{
	@Id
	@Column(nullable=false)
	public String role;

	public AccountType() {}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return this.role;
	}

}
