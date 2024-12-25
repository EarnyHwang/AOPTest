package com.earny.test.controller;

import com.earny.test.monitor.annotation.MonitorOnce;
import com.earny.test.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Log4j2
public class TestController {

  @Autowired TestService testService;

  @GetMapping("/test")
  public String test() {

    log.info("-----------------------------------Test Start-----------------------------------");

    returnOnce(1, 2);
    testService.returnTwice(1, 2);

    log.info("-----------------------------------Test End-----------------------------------");

    return "Test Finish";
  }

  @MonitorOnce
  String returnOnce(int a, int b) {
    log.info("exec returnOnce function");
    return "returnOnce";
  }
}
