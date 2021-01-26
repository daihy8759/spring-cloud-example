package com.daihy8759.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class NacosConsumerFeignController {

  @Autowired
  private com.daihy8759.consumer.service.FeignService FeignService;

  @GetMapping(value = "/test/hi")
  public String test() {
    return FeignService.test("Hi Feign");
  }

  @PostMapping("uploadFile")
  public String uploadFile(MultipartFile file) {
    return FeignService.uploadFile(file);
  }
}
