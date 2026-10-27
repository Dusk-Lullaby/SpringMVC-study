package com.sonnet.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理器
 */
//@Component
public class CustomizedExceptionHandlerResolver implements HandlerExceptionResolver {
    /**
     * 自定义异常处理的方法
     * @param request
     * @param response
     * @param handler
     * @param ex 异常处理对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", ex.toString());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
