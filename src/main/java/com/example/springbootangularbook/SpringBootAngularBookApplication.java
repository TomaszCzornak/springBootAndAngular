package com.example.springbootangularbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringBootAngularBookApplication {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAngularBookApplication.class, args);
    }
//    public void run(String... args) throws Exception {
//        String sql = "INSERT INTO blog (title, author, body) VALUES ("+ "'Awesome Java Project','Seiji Villafranca', 'This is an awesome blog for java')";
//        int rows = jdbcTemplate.update(sql);
//    }
}
