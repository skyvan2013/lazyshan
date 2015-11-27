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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "ems", uniqueConstraints = @UniqueConstraint(columnNames = "product_model"))
public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5493938041801747511L;
	private Integer id;
	private Timestamp version;
	private ProductType belongToType;
	private String productName;
	private String supplierProductModel;
	private String productModel;
	private Set<ProductSet> productSets = new HashSet<ProductSet>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(ProductType belongToType, String supplierProductModel, String productModel) {
		this.belongToType = belongToType;
		this.supplierProductModel = supplierProductModel;
		this.productModel = productModel;
	}

	/** full constructor */
	public Product(ProductType belongToType, String productName, String supplierProductModel, String productModel, Set<ProductSet> productSets) {
		this.belongToType = belongToType;
		this.productName = productName;
		this.supplierProductModel = supplierProductModel;
		this.productModel = productModel;
		this.productSets = productSets;
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
	@JoinColumn(name = "product_type", nullable = false)
	public ProductType getBelongToType() {
		return this.belongToType;
	}

	public void setBelongToType(ProductType belongToType) {
		this.belongToType = belongToType;
	}

	@Column(name = "product_name", length = 45)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "supplier_product_model", nullable = false, length = 10)
	public String getSupplierProductModel() {
		return this.supplierProductModel;
	}

	public void setSupplierProductModel(String supplierProductModel) {
		this.supplierProductModel = supplierProductModel;
	}

	@Column(name = "product_model", unique = true, nullable = false, length = 10)
	public String getProductModel() {
		return this.productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductSet> getProductSets() {
		return this.productSets;
	}

	public void setProductSets(Set<ProductSet> productSets) {
		this.productSets = productSets;
	}

}