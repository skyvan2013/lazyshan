package com.lazyshan.oa.sms.models;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_detail", catalog = "ems")
public class OrderDetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2516992420871415605L;
	private OrderDetailId id;
	private Timestamp version;
	private Order order;
	private ProductSet productSet;
	private Date planProductionDoneTime;
	private String actualProductionDoneTime;
	private String otherInfo;

	// Constructors

	/** default constructor */
	public OrderDetail() {
	}

	/** minimal constructor */
	public OrderDetail(OrderDetailId id, Order order, ProductSet productSet) {
		this.id = id;
		this.order = order;
		this.productSet = productSet;
	}

	/** full constructor */
	public OrderDetail(OrderDetailId id, Order order, ProductSet productSet, Date planProductionDoneTime, String actualProductionDoneTime, String otherInfo) {
		this.id = id;
		this.order = order;
		this.productSet = productSet;
		this.planProductionDoneTime = planProductionDoneTime;
		this.actualProductionDoneTime = actualProductionDoneTime;
		this.otherInfo = otherInfo;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)), @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)) })
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
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
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_set_id", nullable = false)
	public ProductSet getProductSet() {
		return this.productSet;
	}

	public void setProductSet(ProductSet productSet) {
		this.productSet = productSet;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "plan_production_done_time", length = 10)
	public Date getPlanProductionDoneTime() {
		return this.planProductionDoneTime;
	}

	public void setPlanProductionDoneTime(Date planProductionDoneTime) {
		this.planProductionDoneTime = planProductionDoneTime;
	}

	@Column(name = "actual_production_done_time", length = 45)
	public String getActualProductionDoneTime() {
		return this.actualProductionDoneTime;
	}

	public void setActualProductionDoneTime(String actualProductionDoneTime) {
		this.actualProductionDoneTime = actualProductionDoneTime;
	}

	@Column(name = "other_info", length = 5000)
	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}