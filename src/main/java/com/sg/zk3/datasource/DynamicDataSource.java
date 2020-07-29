package com.sg.zk3.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.sg.zk3.datasource.zk.DataSourcePojo;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 14:48
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static volatile DataSource DATA_SOURCE;

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }

    @Override
    protected DataSource determineTargetDataSource() {
        return DATA_SOURCE;
    }

    /**
     * 关闭old连接池
     */
    private static void clear() {
        if (DATA_SOURCE != null && DATA_SOURCE instanceof DruidDataSource) {
            ((DruidDataSource) DATA_SOURCE).close();
            DATA_SOURCE = null;
        }
    }

    /**
     * 更新数据源
     *
     * @param info
     */
    public static void flushDataSource(DataSourcePojo info) {
        //防止正在更新数据的时候 执行数据库操作
        synchronized (DynamicDataSource.class) {
            clear();
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setUrl(info.getUrl());
            druidDataSource.setUsername(info.getUserName());
            druidDataSource.setPassword(info.getPassWord());
            DATA_SOURCE = druidDataSource;
        }
    }
}