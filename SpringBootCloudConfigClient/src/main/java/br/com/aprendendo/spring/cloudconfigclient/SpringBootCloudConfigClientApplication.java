package br.com.aprendendo.spring.cloudconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(QualquerProperties.class) 
public class SpringBootCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudConfigClientApplication.class, args);
	}
}
