package com.test.core.dao.datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value = { "classpath:dataSource.properties" })
@EnableTransactionManagement
public class DataSourceConfig {
	

	/**
	 * 目标数据源
	 * 
	 * @return
	 */
	public Map<Object, Object> targetDataSources(DataSource masterDataSource , DataSource slaveDataSource) {
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(DataSourceType.MASTER.type(), masterDataSource);
		targetDataSources.put(DataSourceType.SLAVE.type(), slaveDataSource);
		return targetDataSources;
	}

	@Bean()
	@ConfigurationProperties(prefix = "dataSource.master")
	public DataSource masterDataSource() {
		return new DruidDataSource();
	}

	@Bean()
	@ConfigurationProperties(prefix = "dataSource.slave" )
	public DataSource slaveDataSource() {
		return new DruidDataSource();
	}
	
	/**
	 * 动态数据源
	 * 
	 * @param master
	 * @return
	 */
	@Bean
	@Primary
	public DynamicDataSource dataSource(DataSource masterDataSource , DataSource slaveDataSource) {
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources(masterDataSource,slaveDataSource));
		dataSource.setDefaultTargetDataSource(masterDataSource());
		return dataSource;
	}
	
	@Bean
	public MapperScannerConfigurer mapper() {
		MapperScannerConfigurer cfg = new MapperScannerConfigurer();
		cfg.setBasePackage("com.test.core.dao.mapper");
		return cfg;
	}

	@Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver
                .getResources("classpath:com/test/core/dao/mapper/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.afterPropertiesSet();
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }
}
