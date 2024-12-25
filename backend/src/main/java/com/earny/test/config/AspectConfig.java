package com.earny.test.config;

import com.earny.test.monitor.aop.MonitorMethodAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.earny.test.monitor")
public class AspectConfig {

  @Bean
  public MonitorMethodAspect theAspect() {
    MonitorMethodAspect aspect = Aspects.aspectOf(MonitorMethodAspect.class);
    return aspect;
  }
}
