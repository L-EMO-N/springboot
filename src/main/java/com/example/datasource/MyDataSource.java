package com.example.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface MyDataSource {

	DataSourceType value() default DataSourceType.Read;	//默认主表
	
}
