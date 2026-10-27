package com.sonnet.controller;

import com.sonnet.exception.CustomizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    // 模拟出现除0异常
    @RequestMapping("/demo1")
    public String demo1() {
        try {
            int i = 10 /0;
        } catch (Exception e) {
            throw new CustomizedException();
        }
        return "success";
    }

    // 模拟出现空指针异常
    @RequestMapping("/demo2")
    public String demo2() {
        int[] arr = null;
        arr[1] = 100;
        return "success";
    }

    // 模拟出现下标越界异常
    @RequestMapping("/demo3")
    public String demo3() {
        int[] arr = new int[3];
        arr[100] = 100;
        return "success";
    }
}
