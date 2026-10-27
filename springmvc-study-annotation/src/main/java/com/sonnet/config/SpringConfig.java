package com.sonnet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring的配置文件，替代Spring的核心配置文件applicationContext.xml
@Configuration
@ComponentScan("com.sonnet")
public class SpringConfig {
    // 在里面定义Spring相关的配置信息
}
