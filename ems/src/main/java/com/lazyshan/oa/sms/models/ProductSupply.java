package com.lazyshan.oa.sms.models;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ProductSupply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_set_has_supplier", catalog = "ems")
public class ProductSupply implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6189997859220527321L;
	private ProductSupplyId id;
	private Timestamp version;
	private Supplier supplier;
	private ProductSet productSet;
	private Integer supplyPrice;
	private String desc;
	private Integer stock;

	// Constructors

	/** default constructor */
	public ProductSupply() {
	}

	/** minimal constructor */
	public ProductSupply(ProductSupplyId id, Supplier supplier, ProductSet productSet, Integer supplyPrice) {
		this.id = id;
		this.supplier = supplier;
		this.productSet = productSet;
		this.supplyPrice = supplyPrice;
	}

	/** full constructor */
	public ProductSupply(ProductSupplyId id, Supplier supplier, ProductSet productSet, Integer supplyPrice, String desc, Integer stock) {
		this.id = id;
		this.supplier = supplier;
		this.productSet = productSet;
		this.supplyPrice = supplyPrice;
		this.desc = desc;
		this.stock = stock;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "productSetId", column = @Column(name = "product_set_id", nullable = false)), @AttributeOverride(name = "supplierId", column = @Column(name = "supplier_id", nullable = false)) })
	public ProductSupplyId getId() {
		return this.id;
	}

	public void setId(ProductSupplyId id) {
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
	@JoinColumn(name = "supplier_id", nullable = false, insertable = false, updatable = false)
	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_set_id", nullable = false, insertable = false, updatable = false)
	public ProductSet getProductSet() {
		return this.productSet;
	}

	public void setProductSet(ProductSet productSet) {
		this.productSet = productSet;
	}

	@Column(name = "supply_price", nullable = false)
	public Integer getSupplyPrice() {
		return this.supplyPrice;
	}

	public void setSupplyPrice(Integer supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	@Column(name = "desc", length = 200)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "stock")
	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}