package com.devarchi33;

import com.devarchi33.config.Properties;
import com.devarchi33.domain.constant.baseball.Position;
import com.devarchi33.domain.constant.baseball.Team;
import com.devarchi33.domain.elastic.Post;
import com.devarchi33.domain.elastic.Tag;
import com.devarchi33.domain.jpa.Customer;
import com.devarchi33.domain.jpa.User;
import com.devarchi33.domain.mongo.Batter;
import com.devarchi33.service.baseball.BaseballService;
import com.devarchi33.service.blog.PostService;
import com.devarchi33.service.shop.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

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
    @Autowired
    private PostService postService;
    @Autowired
    private BaseballService baseballService;

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
//        Map<String, Map<String, String>> servers = props.getServers();
//        Map<String, String> mongoInfo = servers.get("mongo");
//        Map<String, String> elasticInfo = servers.get("elasticsearch");
//        String mongoHost = mongoInfo.get("host");
//        int mongoPort = Integer.parseInt(mongoInfo.get("port"));
//        String elasticHost = elasticInfo.get("host");
//        int elasticPort = Integer.parseInt(elasticInfo.get("port"));
//        String database = mongoInfo.get("database");
//
//        logger.info("Mongo Host: {}", mongoHost);
//        logger.info("Mongo Port: {}", mongoPort);
//        logger.info("Mongo Database: {}", database);
//        logger.info("Elastic Host: {}", elasticHost);
//        logger.info("Elastic Port: {}", elasticPort);

//        memorydbTest();
//        jdbcAccessTest();
//        jpaTest();

//        elasticTest();
        baseballPlayerTest();
    }

    private void baseballPlayerTest() {
        Batter player1 = new Batter();
        player1.setName("이범호");
        player1.setTeam(Team.KIA);
        player1.setMainPosition(Position.THIRD);
        player1.setPositions(Arrays.asList(Position.FIRST, Position.THIRD));
        player1.setGameCount(59);
        player1.setAtBat(216);
        player1.setHit(69);
        player1.setSecondHit(12);
        player1.setThirdHit(0);
        player1.setHomeRun(15);
        player1.setAvg();

        baseballService.save(player1);

        Batter foundPlayer = baseballService.findByBatterName("이범호");
        logger.info("PlayerInfo: {}", foundPlayer);
    }

    private void elasticTest() {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("제임스");
        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("어빙");

        Post post = new Post();
        post.setId("1");
        post.setTitle("Bigining with spring boot application and elasticsearch.");
        post.setTags(Arrays.asList(tag, tag2));
        postService.save(post);

        Post post2 = new Post();
        post2.setId("2");
        post2.setTitle("Bigining with spring boot application");
        post2.setTags(Arrays.asList(tag));
        postService.save(post2);

        Iterable<Post> postList = postService.findAll();
        Iterable<Post> postList2 = postService.findByTagsName("제임스", new PageRequest(0, 10));

        postList.forEach(System.out::println);
        postList2.forEach(System.out::println);

    }

    private void memorydbTest() {
        User user = new User();
        customerService.save(new Customer(1, "Messy", "Lionel", user), user);
        customerService.save(new Customer(2, "Sualez", "Louis", user), user);
        customerService.save(new Customer(3, "Neimar", "Dacilva", user), user);

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

    private void jpaTest() {
        User user = new User();
        Customer created = customerService.save(new Customer(null, "Jungho", "Kang", user), user);
        logger.info("Created: {}", created);

        /**
         * PageRequest args(페이지 수, 페이지당 데이터 수)
         */
        Pageable pageable = new PageRequest(0, 2);
        Page<Customer> customerPage = customerService.findAll(pageable);

        customerService.findAll().forEach(System.out::println);
        customerService.findAllOrderByName(pageable).forEach(System.out::println);

        logger.info("한 페이지당 데이터 수: {}", customerPage.getSize());
        logger.info("현재 페이지 : {}", customerPage.getNumber());
        logger.info("전체 페이지 수 : {}", customerPage.getTotalPages());
        logger.info("전체 데이터 수 : {}", customerPage.getTotalElements());

        customerPage.getContent().forEach(System.out::println);
    }
}
