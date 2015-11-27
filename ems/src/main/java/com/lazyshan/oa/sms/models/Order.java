package com.lazyshan.oa.sms.models;

import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "ems", uniqueConstraints = @UniqueConstraint(columnNames = "private_order_no"))
public class Order implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3996597105176923565L;
	private Integer id;
	private Timestamp version;
	private LogisticsCompany logisticsCompany;
	private String buyerName;
	private String privateOrderNo;
	private String taobaoOrderNo;
	private String buyerAddr;
	private String buyerCellPhoneNum;
	private Timestamp payTime;
	private String wangwang;
	private Integer status;
	private Date planDeliveryTime;
	private Date actualDeliveryTime;
	private String remark;
	private Integer logisticCost;
	private Integer dispatchInstallCost;
	private String dispatcherTel;
	private String otherInfo;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(String buyerName, String privateOrderNo, Timestamp payTime, String wangwang, Integer status, Date planDeliveryTime) {
		this.buyerName = buyerName;
		this.privateOrderNo = privateOrderNo;
		this.payTime = payTime;
		this.wangwang = wangwang;
		this.status = status;
		this.planDeliveryTime = planDeliveryTime;
	}

	/** full constructor */
	public Order(LogisticsCompany logisticsCompany, String buyerName, String privateOrderNo, String taobaoOrderNo, String buyerAddr, String buyerCellPhoneNum, Timestamp payTime, String wangwang, Integer status, Date planDeliveryTime,
			Date actualDeliveryTime, String remark, Integer logisticCost, Integer dispatchInstallCost, String dispatcherTel, String otherInfo, Set<OrderDetail> orderDetails) {
		this.logisticsCompany = logisticsCompany;
		this.buyerName = buyerName;
		this.privateOrderNo = privateOrderNo;
		this.taobaoOrderNo = taobaoOrderNo;
		this.buyerAddr = buyerAddr;
		this.buyerCellPhoneNum = buyerCellPhoneNum;
		this.payTime = payTime;
		this.wangwang = wangwang;
		this.status = status;
		this.planDeliveryTime = planDeliveryTime;
		this.actualDeliveryTime = actualDeliveryTime;
		this.remark = remark;
		this.logisticCost = logisticCost;
		this.dispatchInstallCost = dispatchInstallCost;
		this.dispatcherTel = dispatcherTel;
		this.otherInfo = otherInfo;
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
	@JoinColumn(name = "logistics_company_id")
	public LogisticsCompany getLogisticsCompany() {
		return this.logisticsCompany;
	}

	public void setLogisticsCompany(LogisticsCompany logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	@Column(name = "buyer_name", nullable = false, length = 12)
	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Column(name = "private_order_no", unique = true, nullable = false, length = 14)
	public String getPrivateOrderNo() {
		return this.privateOrderNo;
	}

	public void setPrivateOrderNo(String privateOrderNo) {
		this.privateOrderNo = privateOrderNo;
	}

	@Column(name = "taobao_order_no", length = 16)
	public String getTaobaoOrderNo() {
		return this.taobaoOrderNo;
	}

	public void setTaobaoOrderNo(String taobaoOrderNo) {
		this.taobaoOrderNo = taobaoOrderNo;
	}

	@Column(name = "buyer_addr", length = 200)
	public String getBuyerAddr() {
		return this.buyerAddr;
	}

	public void setBuyerAddr(String buyerAddr) {
		this.buyerAddr = buyerAddr;
	}

	@Column(name = "buyer_cell_phone_num", length = 14)
	public String getBuyerCellPhoneNum() {
		return this.buyerCellPhoneNum;
	}

	public void setBuyerCellPhoneNum(String buyerCellPhoneNum) {
		this.buyerCellPhoneNum = buyerCellPhoneNum;
	}

	@Column(name = "pay_time", nullable = false, length = 19)
	public Timestamp getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	@Column(name = "wangwang", nullable = false, length = 20)
	public String getWangwang() {
		return this.wangwang;
	}

	public void setWangwang(String wangwang) {
		this.wangwang = wangwang;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "plan_delivery_time", nullable = false, length = 10)
	public Date getPlanDeliveryTime() {
		return this.planDeliveryTime;
	}

	public void setPlanDeliveryTime(Date planDeliveryTime) {
		this.planDeliveryTime = planDeliveryTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "actual_delivery_time", length = 10)
	public Date getActualDeliveryTime() {
		return this.actualDeliveryTime;
	}

	public void setActualDeliveryTime(Date actualDeliveryTime) {
		this.actualDeliveryTime = actualDeliveryTime;
	}

	@Column(name = "remark", length = 300)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "logistic_cost")
	public Integer getLogisticCost() {
		return this.logisticCost;
	}

	public void setLogisticCost(Integer logisticCost) {
		this.logisticCost = logisticCost;
	}

	@Column(name = "dispatch_install_cost")
	public Integer getDispatchInstallCost() {
		return this.dispatchInstallCost;
	}

	public void setDispatchInstallCost(Integer dispatchInstallCost) {
		this.dispatchInstallCost = dispatchInstallCost;
	}

	@Column(name = "dispatcher_tel", length = 30)
	public String getDispatcherTel() {
		return this.dispatcherTel;
	}

	public void setDispatcherTel(String dispatcherTel) {
		this.dispatcherTel = dispatcherTel;
	}

	@Column(name = "other_info", length = 5000)
	public String getOtherInfo() {
		return this.otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}