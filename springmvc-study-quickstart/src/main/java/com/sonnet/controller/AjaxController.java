package com.sonnet.controller;

import com.sonnet.pojo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/demo2")
public class AjaxController {

/*
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody Account account) {
        System.out.println(account);
    }
*/

    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody Map<String, Object> map) {
        System.out.println(map);
    }
}
