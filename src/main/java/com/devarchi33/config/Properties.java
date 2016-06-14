package com.devarchi33.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by donghoon on 2016. 6. 9..
 */
@ConfigurationProperties(locations = {"classpath:/application.yml"})
@Component
public class Properties {

    /**
     * application.yml 로 부터 설정 값을 읽어 오기 위한 클래스.
     */
    private Map<String, Map<String, String>> servers = new HashMap<String, Map<String, String>>();
    private String env;

    public Map<String, Map<String, String>> getServers() {
        return servers;
    }

    public void setServers(Map<String, Map<String, String>> servers) {
        this.servers = servers;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
