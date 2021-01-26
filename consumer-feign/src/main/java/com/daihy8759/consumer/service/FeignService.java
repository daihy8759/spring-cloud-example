package com.daihy8759.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "nacos-provider")
public interface FeignService {

  @GetMapping(value = "/test/{message}")
  String test(@PathVariable("message") String message);

  @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String uploadFile(@RequestPart("file") MultipartFile file);

  @PostMapping(value = "/batchUploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  String batchUploadFile(@RequestPart("files") MultipartFile[] files);

}
