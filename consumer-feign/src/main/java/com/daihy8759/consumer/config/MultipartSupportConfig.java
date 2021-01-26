package com.daihy8759.consumer.config;

import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultipartSupportConfig {

  @Bean
  public SpringFormEncoder feignFormEncoder() {
    return new SpringFormEncoder();
  }
}
