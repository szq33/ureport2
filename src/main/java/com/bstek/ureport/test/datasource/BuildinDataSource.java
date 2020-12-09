package com.bstek.ureport.test.datasource;

import java.sql.Connection;

/**
 * 内置数据源接口
 */
public interface BuildinDataSource {

    /**
     * 返回数据源名称
     * @return
     */
    String name();

    /**
     * 返回当前采用数据源的一个连接
     * @return
     */
    Connection getConnection();
}
