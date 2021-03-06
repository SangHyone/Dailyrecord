package kr.human.di.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("Production")
@Configuration
@PropertySource(value = {"classpath:properites/application.properties","classpath:properites/jdcb.properties"})
public class ProductionDatabaseConfig implements DatabaseConfig {
	
	@Value("${m.driver}")
	private String driverClassName;
	@Value("${m.url}")
	private String url;
	@Value("${m.userName}")
	private String userName;
	@Value("${m.password}")
	private String password;
	
    @Override
    @Bean
    public DataSource createDataSource() {
        System.out.println("Creating Production database");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }
 
}
