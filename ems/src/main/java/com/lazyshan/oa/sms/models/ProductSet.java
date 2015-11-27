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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ProductSet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_set", catalog = "ems")
public class ProductSet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085874623943576198L;
	private Integer id;
	private Timestamp version;
	private Product product;
	private String setName;
	private String desc;
	private Integer price;
	private String diagram;
	private String otherInfo;
	private Set<ProductSupply> productSupplies = new HashSet<ProductSupply>(0);
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	// Constructors

	/** default constructor */
	public ProductSet() {
	}

	/** minimal constructor */
	public ProductSet(Product product, Integer price) {
		this.product = product;
		this.price = price;
	}

	/** full constructor */
	public ProductSet(Product product, String setName, String desc, Integer price, String diagram, String otherInfo, Set<ProductSupply> productSupplies, Set<OrderDetail> orderDetails) {
		this.product = product;
		this.setName = setName;
		this.desc = desc;
		this.price = price;
		this.diagram = diagram;
		this.otherInfo = otherInfo;
		this.productSupplies = productSupplies;
		this.orderDetails = orderDetails;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "set_name", length = 45)
	public String getSetName() {
		return this.setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	@Column(name = "desc", length = 200)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "price", nullable = false)
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "diagram", length = 200)
	public String getDiagram() {
		return this.diagram;
	}

	public void setDiagram(String diagram) {
		this.diagram = diagram;
	}

	@Column(name = "other_info", length = 5000)
	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productSet")
	public Set<ProductSupply> getProductSupplies() {
		return this.productSupplies;
	}

	public void setProductSupplies(Set<ProductSupply> productSupplies) {
		this.productSupplies = productSupplies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productSet")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}