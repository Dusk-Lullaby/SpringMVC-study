package com.sonnet.controller;

import com.sonnet.pojo.Account;
import com.sonnet.pojo.User;
import com.sun.jdi.connect.spi.Connection;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RestController  相当于@Controller + @ResponseBody注解
@Controller
@RequestMapping("/demo2")
public class AjaxController {

    @RequestMapping("/testAjax")
    public @ResponseBody Account  testAjax(@RequestBody Account account) {
        // 模拟后端对Account对象进行了处理
        account.setName("jiayi");
        account.setMoney(10000.0);
        System.out.println(account);
        return account;
    }

/*
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody Map<String, Object> map) {
        System.out.println(map);
    }
*/

    // 使用RequestEntity接收请求报文数据
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getBody());
        return "success";
    }

    // 使用ResponseEntity进行数据的响应
    @RequestMapping("/findAll")
    public ResponseEntity<List<Account >> findAll() {
        try {
            List<Account > accountList = new ArrayList<>();
            accountList.add(new Account(1001, "zhangsan", 100.0) );
            accountList.add(new Account(1002, "jiayi", 100.0) );
            accountList.add(new Account(1003, "lisi", 100.0) );
            if (CollectionUtils.isEmpty(accountList)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(accountList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
