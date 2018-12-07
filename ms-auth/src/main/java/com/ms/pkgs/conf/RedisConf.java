package com.ms.pkgs.conf;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * redis配置
 * 
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @see
 * @since 1.0
 */
@Configuration
public class RedisConf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${redis.cluster.host}")
	private String host;

	@Value("${redis.cluster.auth}")
	private String auth;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "RedisConf [host=" + host + ", auth=" + auth + "]";
	}

}
