package com.daihy8759.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartSupportConfig {

//  @Bean
//  public SpringFormEncoder feignFormEncoder() {
//    return new SpringFormEncoder();
//  }

  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver getCommonsMultipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(-1);
    multipartResolver.setMaxInMemorySize(1048576);
    return multipartResolver;
  }
}
