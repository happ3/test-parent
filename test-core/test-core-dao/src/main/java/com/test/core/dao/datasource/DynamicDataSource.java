package com.test.core.dao.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * 
 * @author 
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

	protected Object determineCurrentLookupKey() {
		if(log.isInfoEnabled()){
			log.info("dataSource is {}",DynamicDataSourceHolder.getDataSouce());
		}
		if (DynamicDataSourceHolder.getDataSouce() != null) {
			return DynamicDataSourceHolder.getDataSouce();
		}
		return DataSourceType.MASTER.type();
	}
}

/**
 * 动态数据源决策者
 * 
 * @author 
 *
 */
class DynamicDataSourceHolder {
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	public static void putDataSource(DataSourceType dsType) {
		holder.set(dsType.type());
	}

	public static String getDataSouce() {
		return holder.get();
	}
}
