package com.ms.pkgs.ctrl;

import com.alibaba.fastjson.JSON;
import com.ms.pkgs.conf.MysqlConf;
import com.ms.pkgs.conf.RedisConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求接口
 *
 *
 * <p>
 *
 * @author cs12110 2018年12月6日
 * @since 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloCtrl {

    @Value("${server.port}")
    private String port;


    @Autowired
    private MysqlConf mysql;

    @Autowired
    private RedisConf redis;

    /**
     * 测试方法
     *
     * @param something something
     * @return String of JSON
     */
    @RequestMapping("/say")
    public String say(String something) {
        Map<String, Object> map = new HashMap<>();

        map.put("say", something);
        map.put("port", port);
        map.put("timestamp", System.currentTimeMillis());
        try {
            map.put("mysql", mysql.toString());
            map.put("redis", redis.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map, true);
    }
}
