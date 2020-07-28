package com.sg.zk3.datasource.listener;

import com.sg.zk3.datasource.DynamicDataSource;
import com.sg.zk3.datasource.config.ZkConfig;
import com.sg.zk3.datasource.zk.DataSourceZkUtil;
import org.I0Itec.zkclient.IZkChildListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 监听数据源变化
 *
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 16:54
 */
@Component
public class DataSourceChangeListener {

    @Autowired
    private DataSourceZkUtil zkUtil;

    @Autowired
    private ZkConfig zkConfig;

    @PostConstruct
    private void init() {
        zkUtil.getZkClient().subscribeChildChanges(zkConfig.getDsPath(), new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String>
                    currentChilds) throws Exception {
                DynamicDataSource.flushDataSource(zkUtil.parseDataSouceInfo(currentChilds));
            }
        });
    }

}
