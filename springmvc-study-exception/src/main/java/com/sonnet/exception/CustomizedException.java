package com.sonnet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常类
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "除数不能为0")
public class CustomizedException extends RuntimeException{
}
