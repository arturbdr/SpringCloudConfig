package br.com.poc.spring.cloudconfigclient.config.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

  @Bean
  public Docket configSpringFox() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("configserver-client-sample")
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .tags(new Tag("Sample ConfigServer Client API", "Sample ConfigServer Client API!"));
  }

}
