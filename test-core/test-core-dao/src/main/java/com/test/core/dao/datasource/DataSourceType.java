package com.test.core.dao.datasource;

/**
 * 数据源类型
 * 
 *
 */
public enum DataSourceType {
	MASTER("master"), SLAVE("slave");

	private final String type;

	DataSourceType(String type) {
		this.type = type;
	}

	@DataSource(value = DataSourceType.MASTER)
	public void find() {

	}

	public String type() {
		return type;
	}
}
