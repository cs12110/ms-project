package com.ms.pkgs.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类
 *
 *
 *
 * <p>
 * <p>
 * 为了方便测试,这里面写死数据库配置
 *
 * @author cs12110 2018年12月17日下午3:35:38
 * @since 1.0
 */
@Slf4j
public class JdbcUtil {

    private static ComboPooledDataSource dataSource;

    static {
        init();
    }

    private static void init() {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://47.98.104.252:3306/ms_project?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            dataSource.setUser("root");
            dataSource.setPassword("Root@3306");
            dataSource.setDriverClass("com.mysql.jdbc.Driver");

            dataSource.setInitialPoolSize(2);
            dataSource.setMinPoolSize(2);
            dataSource.setMaxPoolSize(3);
            dataSource.setMaxStatements(50);
            dataSource.setMaxIdleTime(60);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return Connection
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("{}", e.getMessage());
            throw new RuntimeException("get connection from pool is failure", e);
        }
    }

    /**
     * 关闭连接
     *
     * @param conn Connection
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭声明
     *
     * @param stm Statement
     */
    public static void close(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集
     *
     * @param result ResultSet
     */
    public static void close(ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
