package com.example.datasource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

	@Bean(name = "wirte")
	@ConfigurationProperties(prefix = "datasource.write")
	public DataSource dataSource1() {
		System.out.println("主配");
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "read")
	@ConfigurationProperties(prefix = "datasource.read")
	public DataSource dataSource2() {
		System.out.println("从配");
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="dynamicDataSource")
	@Primary	//优先使用，多数据源
	public DataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		DataSource master = dataSource1();
		DataSource slave = dataSource2();
		//设置默认数据源
		dynamicDataSource.setDefaultTargetDataSource(master);	
		//配置多数据源
		Map<Object,Object> map = new HashMap<>();
		map.put(DataSourceType.Read.getName(), master);	//key需要跟ThreadLocal中的值对应
		map.put(DataSourceType.Write.getName(), slave);
		dynamicDataSource.setTargetDataSources(map);			
		return dynamicDataSource;
	}
	
}
