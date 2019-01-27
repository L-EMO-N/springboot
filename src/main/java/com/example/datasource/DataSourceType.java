package com.example.datasource;

public enum DataSourceType {

	// 主表
	Read("read"),
	// 从表
	Write("write");

	private String name;

	private DataSourceType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
