package com.lazyshan.oa.mms.model;

import java.io.Serializable;

/**
 * Model class of 产品供应表.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class ProductSupply implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 产品规格表. */
	private ProductSpec productSpec;

	/** factory. */
	private Factory factory;

	/** 生产周期. */
	private Integer productionCycle;

	/** 库存数量. */
	private Integer stockQuantity;

	/**
	 * Constructor.
	 */
	public ProductSupply() {
	}

	/**
	 * Set the 产品规格表.
	 * 
	 * @param productSpec
	 *            产品规格表
	 */
	public void setProductSpec(ProductSpec productSpec) {
		this.productSpec = productSpec;
	}

	/**
	 * Get the 产品规格表.
	 * 
	 * @return 产品规格表
	 */
	public ProductSpec getProductSpec() {
		return this.productSpec;
	}

	/**
	 * Set the factory.
	 * 
	 * @param factory
	 *            factory
	 */
	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	/**
	 * Get the factory.
	 * 
	 * @return factory
	 */
	public Factory getFactory() {
		return this.factory;
	}

	/**
	 * Set the 生产周期.
	 * 
	 * @param productionCycle
	 *            生产周期
	 */
	public void setProductionCycle(Integer productionCycle) {
		this.productionCycle = productionCycle;
	}

	/**
	 * Get the 生产周期.
	 * 
	 * @return 生产周期
	 */
	public Integer getProductionCycle() {
		return this.productionCycle;
	}

	/**
	 * Set the 库存数量.
	 * 
	 * @param stockQuantity
	 *            库存数量
	 */
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	/**
	 * Get the 库存数量.
	 * 
	 * @return 库存数量
	 */
	public Integer getStockQuantity() {
		return this.stockQuantity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productSpec == null) ? 0 : productSpec.hashCode());
		result = prime * result + ((factory == null) ? 0 : factory.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ProductSupply other = (ProductSupply) obj;
		if (productSpec == null) {
			if (other.productSpec != null) {
				return false;
			}
		} else if (!productSpec.equals(other.productSpec)) {
			return false;
		}
		if (factory == null) {
			if (other.factory != null) {
				return false;
			}
		} else if (!factory.equals(other.factory)) {
			return false;
		}
		return true;
	}

}
