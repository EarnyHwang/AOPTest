package com.earny.test.service.impl;

import com.earny.test.monitor.annotation.MonitorTwice;
import com.earny.test.service.TestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TestServiceImpl implements TestService {

  @MonitorTwice
  public String returnTwice(int a, int b) {
    log.info("exec returnTwice function");
    return "returnTwice";
  }
}
