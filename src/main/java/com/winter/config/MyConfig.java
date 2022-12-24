package com.winter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.winter.repository, com.winter.service")
public class MyConfig {

}
