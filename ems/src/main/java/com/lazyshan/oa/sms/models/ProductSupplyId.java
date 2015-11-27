package com.lazyshan.oa.sms.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProductSupplyId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ProductSupplyId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8936379157502323703L;
	private Integer productSetId;
	private Integer supplierId;

	// Constructors

	/** default constructor */
	public ProductSupplyId() {
	}

	/** full constructor */
	public ProductSupplyId(Integer productSetId, Integer supplierId) {
		this.productSetId = productSetId;
		this.supplierId = supplierId;
	}

	// Property accessors

	@Column(name = "product_set_id", nullable = false)
	public Integer getProductSetId() {
		return this.productSetId;
	}

	public void setProductSetId(Integer productSetId) {
		this.productSetId = productSetId;
	}

	@Column(name = "supplier_id", nullable = false)
	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductSupplyId))
			return false;
		ProductSupplyId castOther = (ProductSupplyId) other;

		return ((this.getProductSetId() == castOther.getProductSetId()) || (this.getProductSetId() != null && castOther.getProductSetId() != null && this.getProductSetId().equals(castOther.getProductSetId())))
				&& ((this.getSupplierId() == castOther.getSupplierId()) || (this.getSupplierId() != null && castOther.getSupplierId() != null && this.getSupplierId().equals(castOther.getSupplierId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getProductSetId() == null ? 0 : this.getProductSetId().hashCode());
		result = 37 * result + (getSupplierId() == null ? 0 : this.getSupplierId().hashCode());
		return result;
	}

}