package com.ms.pkgs.conf;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * mysql配置
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@Configuration
public class MysqlConf implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${mysql.url}")
	private String url;

	@Value("${mysql.user}")
	private String user;

	@Value("${mysql.password}")
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MysqlConf clone() {
		MysqlConf conf = null;
		try {
			conf = (MysqlConf) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conf;
	}

	@Override
	public String toString() {
		return "MysqlConf [url=" + url + ", user=" + user + ", password=" + password + "]";
	}

}
