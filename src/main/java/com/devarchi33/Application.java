package com.devarchi33;

import com.devarchi33.config.Properties;
import com.devarchi33.domain.Customer;
import com.devarchi33.persistance.jpa.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by donghoon on 2016. 6. 9..
 */
@SpringBootApplication
@EnableWebMvc
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Properties props;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * static folder 이하에 있는 정적자원들 인식.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

    @Override
    public void run(String... strings) throws Exception {
        Map<String, Map<String, String>> servers = props.getServers();
        Map<String, String> mongoInfo = servers.get("mongo");
        String host = mongoInfo.get("host");
        int port = Integer.parseInt(mongoInfo.get("port"));
        String database = mongoInfo.get("database");

        logger.info("Mongo Host: {}", host);
        logger.info("Mongo Port: {}", port);
        logger.info("Mongo Database: {}", database);

        memorydbTest();
        jdbcAccessTest();
        jdbcObjectTest();
    }

    private void memorydbTest() {
        customerService.save(new Customer(1, "James", "Lebron"));
        customerService.save(new Customer(2, "Irving", "Kyrie"));
        customerService.save(new Customer(3, "Curry", "Stephan"));

        customerService.findAll().forEach(System.out::println);
    }

    private void jdbcAccessTest() {
        String sql = "SELECT :a + :b";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("a", 100)
                .addValue("b", 200);

        Integer result = jdbcTemplate.queryForObject(sql, param, Integer.class);

        logger.info("result: {}", result);
    }

    private void jdbcObjectTest() {
        String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", 1);

        Customer result = jdbcTemplate.queryForObject(sql, param, (rs, i) -> {
            return new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
        });

        logger.info("result: {}", result);
    }
}
