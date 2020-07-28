package com.sg.zk3.datasource.listener;

import com.sg.zk3.datasource.DynamicDataSource;
import com.sg.zk3.datasource.zk.DataSourceZkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动时获取数据源
 *
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 16:52
 */
@Component
public class ApplicationStartListener implements ApplicationRunner {

    @Autowired
    private DataSourceZkUtil zkClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DynamicDataSource.flushDataSource(zkClient.getDataSouceInfo());
    }
}
