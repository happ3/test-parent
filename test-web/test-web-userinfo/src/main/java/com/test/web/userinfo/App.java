package com.test.web.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.test.*")
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("--消费方启动--");
    	SpringApplication.run(App.class, args);
    }
}
