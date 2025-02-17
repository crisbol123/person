package co.pragma.person.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintDataSourceConfigs {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;


    @PostConstruct
    public void printProperties() {
        System.out.println("Database URL: prueba cambio" + dbUrl);
        System.out.println("Database Username: " + username);
    }
}