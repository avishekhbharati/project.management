package sef.project.management.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", nullable = false)
	private Integer id;

	@Column(name = "USERNAME", nullable = false)
	private String userName;

	@Column(name = "EMAIL_ID", nullable = false)
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ContractorDetails> contractorDetails = new ArrayList<ContractorDetails>();

	public ContractorDetails addContractorDetails(ContractorDetails contractorDetails) {
		contractorDetails.setUser(this);
		getContractorDetails().add(contractorDetails);
		return contractorDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ContractorDetails> getContractorDetails() {
		return contractorDetails;
	}

	public void setContractorDetails(List<ContractorDetails> contractorDetails) {
		this.contractorDetails = contractorDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}