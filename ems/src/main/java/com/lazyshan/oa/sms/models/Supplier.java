package com.lazyshan.oa.sms.models;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Supplier entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "supplier", catalog = "ems")
public class Supplier implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9097210780134295905L;
	private Integer id;
	private Timestamp version;
	private String supplierName;
	private Timestamp createTime;
	private Boolean status;
	private Set<ProductSupply> productSupplies = new HashSet<ProductSupply>(0);

	// Constructors

	/** default constructor */
	public Supplier() {
	}

	/** minimal constructor */
	public Supplier(String supplierName, Timestamp createTime, Boolean status) {
		this.supplierName = supplierName;
		this.createTime = createTime;
		this.status = status;
	}

	/** full constructor */
	public Supplier(String supplierName, Timestamp createTime, Boolean status, Set<ProductSupply> productSupplies) {
		this.supplierName = supplierName;
		this.createTime = createTime;
		this.status = status;
		this.productSupplies = productSupplies;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Version
	@Column(name = "version", nullable = false, length = 19)
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@Column(name = "supplier_name", nullable = false, length = 40)
	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status", nullable = false)
	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "supplier")
	public Set<ProductSupply> getProductSupplies() {
		return this.productSupplies;
	}

	public void setProductSupplies(Set<ProductSupply> productSupplies) {
		this.productSupplies = productSupplies;
	}

}