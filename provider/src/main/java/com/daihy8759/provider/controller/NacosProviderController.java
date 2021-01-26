package com.daihy8759.provider.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NacosProviderController {

  @Value("${server.port}")
  private String port;

  // 注入配置文件上下文
  @Autowired
  private ConfigurableApplicationContext applicationContext;

  @GetMapping(value = "/test/{message}")
  public String test(@PathVariable String message) {
    return "Hello Nacos Discovery " + message + " i am from port " + port;
  }

  // 从上下文中读取配置
  @GetMapping(value = "/hi")
  public String sayHi() {
    return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
  }

  @PostMapping("uploadFile")
  public String uploadFile(MultipartFile file) throws IOException {
    if (file != null && file.getInputStream() != null) {
      IOUtils.copy(file.getInputStream(), new FileOutputStream(
          "/users/daihy/downloads/uploadFile." + FilenameUtils
              .getExtension(file.getOriginalFilename())));
      return "ok";
    }
    return "fail";
  }
}
