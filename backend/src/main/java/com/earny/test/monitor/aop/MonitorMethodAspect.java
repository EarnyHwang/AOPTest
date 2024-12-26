package com.earny.test.monitor.aop;

import com.earny.test.monitor.annotation.MonitorOnce;
import com.earny.test.monitor.annotation.MonitorTwice;
import com.earny.test.monitor.service.MonitorService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Aspect
@Log4j2
@Configurable  // Inject Spring beans into non-managed objects
public class MonitorMethodAspect {

  @Autowired MonitorService monitorService;

  @Pointcut("@annotation(monitor)")
  public void callMonitorOnce(MonitorOnce monitor) {}

  @Pointcut("@annotation(monitor)")
  public void callMonitorTwice(MonitorTwice monitor) {}

  @AfterReturning(
      value = "callMonitorOnce(monitor) && execution(* *(..)) && args(.., a, b)",
      returning = "result")
  public void afterReturn1(JoinPoint joinPoint, MonitorOnce monitor, int a, int b, String result) {
    log.info("afterReturn1 joinPoint： " + joinPoint + " result：" + result);
    if (monitorService == null)
      throw new RuntimeException("@Autowired MonitorService is not working unexpectedly");
  }

  @AfterReturning(
      value = "callMonitorTwice(monitor) && execution(* *(..)) && args(.., a, b)",
      returning = "result")
  public void afterReturn2(JoinPoint joinPoint, MonitorTwice monitor, int a, int b, String result) {
    log.info("afterReturn2 joinPoint： " + joinPoint + " result：" + result);
    if (monitorService == null)
      throw new RuntimeException("@Autowired MonitorService is not working unexpectedly");
  }
}
