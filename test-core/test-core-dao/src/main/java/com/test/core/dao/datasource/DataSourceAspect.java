package com.test.core.dao.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * 数据源切面
 * 
 *
 */
@Configuration
@Aspect
public class DataSourceAspect implements Ordered {
	
	/**
	 * 切入点为 注解了 @DataSource 的方法
	 * 
	 * @param dataSource
	 */
	@Before(value = "@annotation(dataSource)")
	public void before(JoinPoint jp, DataSource dataSource) {
		DynamicDataSourceHolder.putDataSource(dataSource.value());
	}

	/**
	 * 在 目标对象（例如 service 中的方法中）使用 @DataSource 和 @Transactional
	 * 注解时，默认标注 @Transactional 的切面的通知方法会优先执行，切换数据源操作将失效，通过order将
	 * DataSourceAspect 切面设置为1，并通过设置 @EnableTransactionManagement(order = 2)
	 * 将@Transactional的切面order设为2
	 */
	@Override
	public int getOrder() {
		return -1;
	}
}
