package com.bunroo.incidentmanagement.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration(proxyBeanMethods = false)
public class WebConfig {
    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSourceBuilder = new DriverManagerDataSource();
        Properties prop=new Properties();
        String propFileName="application.properties";
        InputStream is=getClass().getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataSourceBuilder.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSourceBuilder.setUrl(prop.getProperty("app.datasource.url"));
        dataSourceBuilder.setUsername(prop.getProperty("app.datasource.username"));
        dataSourceBuilder.setPassword(prop.getProperty("app.datasource.password"));

        return dataSourceBuilder;
    }
}
