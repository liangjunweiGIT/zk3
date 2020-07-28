package com.sg.zk3.datasource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 16:55
 */
@Component
public class ZkConfig {
    @Value("${zk.address}")
    private String address;

    @Value("${zk.dataSource.path}")
    private String dsPath;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDsPath() {
        return dsPath;
    }

    public void setDsPath(String dsPath) {
        this.dsPath = dsPath;
    }
}
