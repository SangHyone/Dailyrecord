package kr.human.di.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
@Configuration
@ComponentScan("kr.human.di") // kr.human.di 패키지에 있는 클래스들을 검색해서 자바빈을 자동으로 등록해라!!
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {
	@Value("${m.driver}")
	private String driverClassName;
	@Value("${m.url}")
	private String url;
	@Value("${m.userName}")
	private String userName;
	@Value("${m.password}")
	private String password;
	
    @Bean
    public DataSource dataSource() {
        System.out.println("Creating DEV database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
}
