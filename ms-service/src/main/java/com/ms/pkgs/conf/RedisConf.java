package com.ms.pkgs.conf;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * redis配置
 *
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@Component
@Data
public class RedisConf implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Value("${redis.cluster.host}")
    private String host;

    @Value("${redis.cluster.auth}")
    private String auth;


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
