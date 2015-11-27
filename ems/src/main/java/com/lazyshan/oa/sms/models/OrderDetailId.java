package com.lazyshan.oa.sms.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderDetailId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class OrderDetailId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5703849200294845212L;
	private Integer id;
	private Integer orderId;

	// Constructors

	/** default constructor */
	public OrderDetailId() {
	}

	/** full constructor */
	public OrderDetailId(Integer id, Integer orderId) {
		this.id = id;
		this.orderId = orderId;
	}

	// Property accessors

	@Column(name = "id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderDetailId))
			return false;
		OrderDetailId castOther = (OrderDetailId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
				&& ((this.getOrderId() == castOther.getOrderId()) || (this.getOrderId() != null && castOther.getOrderId() != null && this.getOrderId().equals(castOther.getOrderId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		return result;
	}

}