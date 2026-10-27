package com.sonnet.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理
 */
// @ControllerAdvice // @ControllerAdvice 将当前类标识为异常处理的组件
public class MyExceptionHandler {

/*
    // 定义一个专门处理除0异常的方法
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView arithmeticExceptionHandler(ArithmeticException exception) {
        ModelAndView modelAndView = new ModelAndView();
        // 设置异常原因
        modelAndView.addObject("msg", exception.toString());
        // 设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }

    // 处理空指针异常
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullPointerException(NullPointerException exception) {
        ModelAndView modelAndView = new ModelAndView();
        // 设置异常原因
        modelAndView.addObject("msg", exception.toString());
        // 设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }

    // 处理下标越界异常
    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ModelAndView arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException exception) {
        ModelAndView modelAndView = new ModelAndView();
        // 设置异常原因
        modelAndView.addObject("msg", exception.toString());
        // 设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }
*/

    /**
     * @ExceptionHandler用于设置所标识方法处理的异常
     * 处理异常
     * @param exception 封装的是对应异常处理的信息
     * @return
     */
    // @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView();
        // 设置异常原因
        modelAndView.addObject("msg", exception.toString());
        // 设置错误处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
