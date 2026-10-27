package com.sonnet.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class InterceptorDemo1 implements HandlerInterceptor {

    /**
     * 前置拦截器方法，在目标方法之前执行，其返回值为布尔值，true标识拦截器放行，控制器就会得到执行，如果返回值为false，控制器方法就不会执行
     * @param request
     * @param response
     * @param handler
     * @return 其返回值为布尔值，true标识拦截器放行，控制器就会得到执行，如果返回值为false，控制器方法就不会执行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1 is running");
        return true;
    }

    /**
     * 后置拦截器，在控制器方法之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1 is running");
    }

    /**
     * 最终拦截器，在视图渲染之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1 method is running");
    }

}
