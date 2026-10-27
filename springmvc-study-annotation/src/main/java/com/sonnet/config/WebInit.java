package com.sonnet.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 这个类的作用就类似于web.xml
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载spring的核心配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 加载springmvc的配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    // 设置前端控制器的映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 定义过滤器的方法
    @Override
    protected Filter[] getServletFilters() {
        // 配置编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        characterEncodingFilter.setForceRequestEncoding(true);
        // 设置HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
