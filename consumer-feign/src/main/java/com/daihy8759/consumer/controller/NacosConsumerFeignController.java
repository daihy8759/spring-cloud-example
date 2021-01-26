package com.daihy8759.consumer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

  @PostMapping("uploadFileChangeName")
  public String uploadFileChangeName(MultipartFile file) {
    CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) file;
    commonsMultipartFile.getFileItem().setFieldName("file1");
    return FeignService.uploadFile(commonsMultipartFile);
  }

  @PostMapping("batchUploadFile")
  public String batchUploadFile(MultipartRequest request) {
    MultiValueMap<String, MultipartFile> fileMap = request.getMultiFileMap();
    List<MultipartFile> list = new ArrayList<>(fileMap.size());
    for (Entry<String, List<MultipartFile>> entry : fileMap.entrySet()) {
      list.add(entry.getValue().get(0));
    }
    return FeignService.batchUploadFile(list.toArray(new MultipartFile[0]));
  }
}
