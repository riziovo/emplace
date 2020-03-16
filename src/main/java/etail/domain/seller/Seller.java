package etail.domain.seller;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import etail.domain.account.AccountType;
import etail.domain.account.Credential;

@Entity
@Table(name="SELLER")
public class Seller implements SellerEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SELLER_ID", updatable=false)
	public Long id;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_SELLERPINFO_ID", nullable=true)
//	@JsonIgnore
	public SellerPInfo sellerPInfo;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_SELLER_HEAD", nullable=false)
//	@JsonIgnore
	public SellerHead sellerHead;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="FK_SELLER_BODY", nullable=false)
//	@JsonIgnore
	public SellerBody sellerBody;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="FK_ACCOUNTYPE")
	private AccountType sellerAccountType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="FK_CREDENTIAL_ID", nullable=true)
	private Credential credential;
	
	public SellerPInfo getSellerPInfo() {
		return sellerPInfo;
	}

	public void setSellerPInfo(SellerPInfo sellerPInfo) {
		this.sellerPInfo = sellerPInfo;
	}

	
	public AccountType getSellerAccountType() {
		return sellerAccountType;
	}

	public void setSellerAccountType(AccountType sellerAccountType) {
		this.sellerAccountType = sellerAccountType;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public Seller() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SellerHead getSellerHead() {
		return sellerHead;
	}

	public void setSellerHead(SellerHead sellerHead) {
		this.sellerHead = sellerHead;
	}

	public SellerBody getSellerBody() {
		return sellerBody;
	}

	public void setSellerBody(SellerBody sellerBody) {
		this.sellerBody = sellerBody;
	}

	public AccountType getAccountType() {
		return sellerAccountType;
	}

	public void setAccountType(AccountType sellerAccountType) {
		this.sellerAccountType = sellerAccountType;
	}
	
	@Override
	public String getSellerInfo() {
		return this.sellerHead.getAbout();
	}
}