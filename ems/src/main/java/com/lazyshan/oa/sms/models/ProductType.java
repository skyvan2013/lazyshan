package com.lazyshan.oa.sms.models;

// Generated 2015-6-25 1:46:59 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * ProductType generated by hbm2java
 */
@Entity
@Table(name = "product_type", catalog = "lazyshan", uniqueConstraints = {
		@UniqueConstraint(columnNames = "typeName"),
		@UniqueConstraint(columnNames = "parentTypeId") })
public class ProductType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 390744438666406378L;
	private Integer typeId;
	private Date version;
	private ProductType productType;
	private String typeName;
	private Integer typeLevel;
	private Integer position;
	private String desc;
	private Set<ProductType> productTypes = new HashSet<ProductType>(0);

	public interface JsonViewClass1 {
	};

	public ProductType() {
	}

	public ProductType(String typeName, Integer typeLevel, Integer position) {
		this.typeName = typeName;
		this.typeLevel = typeLevel;
		this.position = position;
	}

	public ProductType(ProductType productType, String typeName,
			Integer typeLevel, Integer position, String desc,
			Set<ProductType> productTypes) {
		this.productType = productType;
		this.typeName = typeName;
		this.typeLevel = typeLevel;
		this.position = position;
		this.desc = desc;
		this.productTypes = productTypes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "typeId", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "version", length = 19)
	public Date getVersion() {
		return this.version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentTypeId", unique = true)
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	@Column(name = "typeName", unique = true, nullable = false, length = 20)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "typeLevel", nullable = false)
	public Integer getTypeLevel() {
		return this.typeLevel;
	}

	public void setTypeLevel(Integer typeLevel) {
		this.typeLevel = typeLevel;
	}

	@Column(name = "position", nullable = false)
	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Column(name = "desc", length = 45)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
	public Set<ProductType> getProductTypes() {
		return this.productTypes;
	}

	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

}
