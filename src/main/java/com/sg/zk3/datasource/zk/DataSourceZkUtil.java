package com.sg.zk3.datasource.zk;

import com.alibaba.fastjson.JSONObject;
import com.sg.zk3.datasource.config.ZkConfig;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 17:09
 */
@Component
public class DataSourceZkUtil {
    @Autowired
    private ZkConfig zkConfig;

    private ZkClient zkClient;

    @PostConstruct
    private void init() {
        zkClient = new ZkClient(zkConfig.getAddress());
        zkClient.createPersistent(zkConfig.getDsPath());
    }

    /**
     * 数据格式{"url":"jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&useAffectedRows=true","userName":"root","password":"root"}
     *
     * @return
     */
    public DataSourcePojo getDataSouceInfo() {
        List<String> children = zkClient.getChildren(zkConfig.getDsPath());
        return parseDataSouceInfo(children);
    }

    public DataSourcePojo parseDataSouceInfo(List<String> children) {
        if (children.size() == 0) {
            throw new RuntimeException("未读取到数据源");
        }
        return JSONObject.parseObject(children.get(0), DataSourcePojo.class);
    }


    public ZkClient getZkClient() {
        return zkClient;
    }

    public void setZkClient(ZkClient zkClient) {
        this.zkClient = zkClient;
    }
}
