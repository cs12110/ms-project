package com.ms.pkgs.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc工具类
 * 
 * 
 *
 * <p>
 * 
 * 为了方便测试,这里面写死数据库配置
 *
 * @author cs12110 2018年12月17日下午3:35:38
 * @see
 * @since 1.0
 */
public class JdbcUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
	private static ComboPooledDataSource dataSource;

	static {
		init();
	}

	public static void init() {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setJdbcUrl(
					"jdbc:mysql://47.98.104.252:3306/ms_project?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
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
			logger.error("{}", e);
			throw new RuntimeException("get connection from pool is failure", e);
		}
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
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
	 * @param stm
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
	 * @param result
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
