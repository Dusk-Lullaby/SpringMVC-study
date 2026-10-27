package com.sonnet.config;

import com.sonnet.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 其作用等同于springmvc.xml
 */
@Configuration
@ComponentScan(basePackages = "com.sonnet") // 定义包扫描的注解
@EnableWebMvc // 开启处理器映射器 处理器适配器的自动配置  等同于    <mvc:annotation-driven></mvc:annotation-driven>
public class SpringMVCConfig implements WebMvcConfigurer {

    // 配置视图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        // 设置前缀
        internalResourceViewResolver.setPrefix("/pages/");
        // 设置后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    // 配置文件上传解析器
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        MyInterceptor myInterceptor = new MyInterceptor();
        registry.addInterceptor(myInterceptor).addPathPatterns("/hello/demo1");
    }
}
