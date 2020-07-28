package com.sg.zk3.datasource.zk;

/**
 * 数据源信息
 *
 * @author junwei.liang01@ucarinc.com
 * @date 2020/7/28 17:25
 */
public class DataSourcePojo {
    /**
     * jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&useAffectedRows=true
     */
    private String url;
    /**
     * root
     */
    private String userName;
    /**
     * root
     */
    private String passWord;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
