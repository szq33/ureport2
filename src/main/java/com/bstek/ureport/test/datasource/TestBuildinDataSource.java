package com.bstek.ureport.test.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class TestBuildinDataSource implements BuildinDataSource {
    private static final String NAME="MyDataSource";

    @Autowired
    private DataSource dataSource;

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
    }
}
