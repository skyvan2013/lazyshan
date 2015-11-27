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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * LogisticsCompany entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "logistics_company", catalog = "ems", uniqueConstraints = @UniqueConstraint(columnNames = "company_name"))
public class LogisticsCompany implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 535080607813561803L;
	private Integer id;
	private Timestamp version;
	private String companyName;
	private String tel;
	private String addr;
	private Short type;
	private Set<Order> orders = new HashSet<Order>(0);

	// Constructors

	/** default constructor */
	public LogisticsCompany() {
	}

	/** minimal constructor */
	public LogisticsCompany(String companyName, String tel, Short type) {
		this.companyName = companyName;
		this.tel = tel;
		this.type = type;
	}

	/** full constructor */
	public LogisticsCompany(String companyName, String tel, String addr, Short type, Set<Order> orders) {
		this.companyName = companyName;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
		this.orders = orders;
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
	@Column(name = "version", length = 19)
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@Column(name = "company_name", unique = true, nullable = false, length = 45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "tel", nullable = false, length = 80)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "addr", length = 100)
	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "logisticsCompany")
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}