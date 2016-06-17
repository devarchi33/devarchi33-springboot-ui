package com.devarchi33.persistance.elasticsearch;

import com.devarchi33.config.Properties;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.Map;

/**
 * Created by donghoon on 2016. 6. 17..
 */
@EnableElasticsearchRepositories("com/devarchi33/persistance/elasticsearch")
public class ElasticConfig {

    @Autowired
    private Properties properties;

    @Bean
    public Client elasticClient() {
        TransportClient client = new TransportClient();
        TransportAddress address = new InetSocketTransportAddress(getElasticInfo("host"), Integer.parseInt(getElasticInfo("port")));
        client.addTransportAddress(address);

        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(elasticClient());
    }

    private String getElasticInfo(String key) {
        Map<String, Map<String, String>> servers = properties.getServers();
        Map<String, String> elasticInfo = servers.get("elasticsearch");
        return elasticInfo.get(key);
    }
}
