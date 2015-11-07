package com.lazyshan.oa.sms.models;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * ProductType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product_type", catalog = "lazyshan", uniqueConstraints = @UniqueConstraint(columnNames = "typeName"))
public class ProductType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2501440423971060619L;
	private Integer typeId;
	private Timestamp version;
	private ProductType parentProductType;
	private String typeName;
	private Integer typeLevel;
	private Integer position;
	private String desc;
	private Set<ProductType> productTypes = new HashSet<ProductType>(0);

	// Constructors

	/** default constructor */
	public ProductType() {
	}

	/** minimal constructor */
	public ProductType(String typeName, Integer typeLevel, Integer position) {
		this.typeName = typeName;
		this.typeLevel = typeLevel;
		this.position = position;
	}

	/** full constructor */
	public ProductType(ProductType parentProductType, String typeName,
			Integer typeLevel, Integer position, String desc,
			Set<ProductType> productTypes) {
		this.parentProductType = parentProductType;
		this.typeName = typeName;
		this.typeLevel = typeLevel;
		this.position = position;
		this.desc = desc;
		this.productTypes = productTypes;
	}

	// Property accessors
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
	@Column(name = "version", length = 19)
	public Timestamp getVersion() {
		return this.version;
	}

	public void setVersion(Timestamp version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentTypeId")
	public ProductType getParentProductType() {
		return this.parentProductType;
	}

	public void setParentProductType(ProductType parentProductType) {
		this.parentProductType = parentProductType;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentProductType")
	public Set<ProductType> getProductTypes() {
		return this.productTypes;
	}

	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

}