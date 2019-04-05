package com.ms.pkgs.conf;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * mysql配置
 *
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@Component
@Data
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


    @Override
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
        return JSON.toJSONString(this);
    }

}
