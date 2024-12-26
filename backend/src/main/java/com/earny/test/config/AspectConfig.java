package com.earny.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@ComponentScan("com.earny.test.monitor")
// Enable @Configurable aspect to inject Spring beans into non-managed objects
@EnableSpringConfigured
public class AspectConfig {}
