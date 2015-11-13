package com.lazyshan.oa.sms.temp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

public class ProductType {

	private String name;
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static class Product {
		public static final String imagePathPrefix = "/statics/upload/images/pricecompute/";
		private String name;
		private List<ProductSet> sets;
		private String imageName;

		public String getImage() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imagePathPrefix + imageName;
		}

		public List<ProductSet> getSets() {
			return sets;
		}

		public void setSets(List<ProductSet> sets) {
			this.sets = sets;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static class ProductSet {
			private String name;
			private BigDecimal volume;
			private Integer dailyPrice;
			private Integer activityPrice;
			private Integer cost;

			public Integer getDailyPrice() {
				return dailyPrice;
			}

			public void setDailyPrice(Integer dailyPrice) {
				this.dailyPrice = dailyPrice;
			}

			public Integer getActivityPrice() {
				return activityPrice;
			}

			public void setActivityPrice(Integer activityPrice) {
				this.activityPrice = activityPrice;
			}

			public Integer getCost() {
				return cost;
			}

			public void setCost(Integer cost) {
				this.cost = cost;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public BigDecimal getVolume() {
				return volume;
			}

			public void setVolume(Float volume) {
				this.volume = new BigDecimal(volume).setScale(1,RoundingMode.HALF_UP);
			}
		}
	}

}
