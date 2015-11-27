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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * ProductType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_type", catalog = "ems")
public class ProductType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8512297403792085448L;
	private Integer id;
	private Timestamp version;
	private ProductType parentType;
	private String typeName;
	private Timestamp createTime;
	private Integer orderValue;
	private Set<ProductType> subTypes = new HashSet<ProductType>(0);
	private Set<Product> products = new HashSet<Product>(0);

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** minimal constructor */
	public ProductType(String typeName, Timestamp createTime, Integer orderValue) {
		this.typeName = typeName;
		this.createTime = createTime;
		this.orderValue = orderValue;
	}

	/** full constructor */
	public ProductType(ProductType parentType, String typeName, Timestamp createTime, Integer orderValue, Set<ProductType> subTypes, Set<Product> products) {
		this.parentType = parentType;
		this.typeName = typeName;
		this.createTime = createTime;
		this.orderValue = orderValue;
		this.subTypes = subTypes;
		this.products = products;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_type_id")
	public ProductType getParentType() {
		return this.parentType;
	}

	public void setParentType(ProductType parentType) {
		this.parentType = parentType;
	}

	@Column(name = "type_name", nullable = false, length = 20)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "order_value", nullable = false)
	public Integer getOrderValue() {
		return this.orderValue;
	}

	public void setOrderValue(Integer orderValue) {
		this.orderValue = orderValue;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentType")
	@OrderBy("orderValue")
	public Set<ProductType> getSubTypes() {
		return this.subTypes;
	}

	public void setSubTypes(Set<ProductType> subTypes) {
		this.subTypes = subTypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "belongToType")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "【id:" + id + ",typeName:" + typeName+",orderValue:"+orderValue+"】";
	}

}