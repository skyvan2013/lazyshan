package com.lazyshan.oa.lms.common;

import java.util.Collections;
import java.util.List;

public class Pager<T> {
	/**
	 * 查询页数
	 */
	private int page;

	/**
	 * 行数
	 */
	private int rows;

	/**
	 * 查询结果
	 */
	private List<T> result = Collections.EMPTY_LIST;

	private int total;

	public OutPager<T> toOutPager() {
		return new OutPager<T>(total, result);
	}

	public int getPage() {
		return page < 1 ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;

	}

	public static class OutPager<T> {
		private int total;
		private List<T> rows;

		public OutPager(int total, List<T> rows) {
			this.total = total;
			this.rows = rows;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public List<T> getRows() {
			return rows;
		}

		public void setRows(List<T> rows) {
			this.rows = rows;
		}
	}

}
