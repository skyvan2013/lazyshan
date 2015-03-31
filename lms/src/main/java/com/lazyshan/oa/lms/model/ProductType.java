package com.lazyshan.oa.lms.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProductType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_type", catalog = "lazyshan")
public class ProductType implements java.io.Serializable {

	// Fields

	private Short productType;
	private String productTypeDesc;

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** minimal constructor */
	public ProductType(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}


	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_type", unique = true, nullable = false)
	public Short getProductType() {
		return this.productType;
	}

	public void setProductType(Short productType) {
		this.productType = productType;
	}

	@Column(name = "product_type_desc", nullable = false, length = 20)
	public String getProductTypeDesc() {
		return this.productTypeDesc;
	}

	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}

}