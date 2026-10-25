package com.sonnet.controller;

import com.sonnet.pojo.Account;
import com.sonnet.pojo.Student;
import com.sonnet.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;

// http://localhost:8088/demo1/hello
@Controller
@RequestMapping("demo1") // 一级路径
@SessionAttributes(value = {"username", "password", "age"}) // 指定向session作用域中存储哪些数据
public class HelloController {

    /**
     * 二级路径
     * path/value:描述的是请求资源的url路径
     * method:描述的是指定以什么样的请求方法来进行资源的访问，如果请求方式不正确，会报错，抛出405异常
     * params:在请求当前控制器方法的时候，必须携带指定的参数，如果不携带参数，此时会报400的异常
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET,params = {"username", "age"})
    public String hello() {
        return "success"; // pages/success.jsp
    }

    /**
     * 如果前端提交的参数是字面量数据（简单字符串或者数字），在控制器方法中，
     * 我们只需要声明和前端提交的参数是一致的即可
     * @param username
     * @param age
     * @return
     */
    @RequestMapping("/getBasicParam")
    public String getBasisParam(String username, Integer age) {
        System.out.println(username);
        System.out.println(age);
        return "success";
    }

    // 接收前端提交的表单数据
    @RequestMapping("/getPojoParams")
    public String getPojoParams(Account account) {
        System.out.println(account);
        return "success";
    }

    // 接收前端的集合类型方法
    @RequestMapping("findUser")
    public String findUser(User user) {
        System.out.println(user);
        return "success";
    }

    // 接收前端提交的日期类型方法    @DateTimeFormat按照指定的各式将数据转换成日期类型
    @RequestMapping("/getDate")
    public String getDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println(date);
        return "success";
    }

    @RequestMapping("/getDate2")
    public String getDate2(Date date) {
        System.out.println(date);
        return "success";
    }

    // 测试使用原生的servlet API
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession httpSession) {
        try {
            String username = request.getParameter("username");
            String age = request.getParameter("age");
            System.out.println(username + " => " + age);
            // 重定向到success.jsp页面
            response.sendRedirect("/pages/success.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @RequestParam注解：如果前后参数名称不一样，我们可以使用该注解实现前后参数的绑定
     *      value/name：描述参数的名称，这个值是前端参数的名称
     *      required：默认值为true，标识当前参数是必须携带的，如果前端没有携带该参数，就会报400异常
     *      defaultValue：默认值 防止空指针异常 如果前端没有提交参数（null），就使用默认值替代
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false, defaultValue = "zhangsan") String name,
                                   @RequestParam(value = "age", required = false, defaultValue = "33") Integer age) {
        System.out.println(name + " => " + age);
        return "success";
    }

    /**
     * 测试RequestBody注解的使用
     * @param body      username=admin&password=123&age=123
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body); // username=admin&password=123&age=123
        return "success";
    }

    /**
     * 测试RequestHeader注解的使用
     * @param header    zh-CN,zh;q=0.9,zh-TW;q=0.8
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("accept-language") String header) {
        System.out.println(header);
        return "success";
    }

    /**
     * 测试CookieValue注解的使用
     * @param cookieValue   5075D775C264CFA362B9EE2AD3A990F8
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    // 存储数据
    @RequestMapping("/putSession")
    public String putSession(Model model) {
        // 通过model对象向作用域中尊出数据
        model.addAttribute("username", "jia");
        model.addAttribute("password", "admin123");
        model.addAttribute("age", "18");
        return "success";
    }

    // 读取数据
    @RequestMapping("/getSession")
    public String getSession(ModelMap modelMap) {
        Object username = modelMap.get("username");
        Object password = modelMap.get("password");
        Object age = modelMap.get("age");
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        return "success";
    }

    // 删除session中的数据
    @RequestMapping("/removeSession")
    public String removeSession(SessionStatus sessionStatus) {
        sessionStatus.setComplete(); // 清空session作用域中的数据
        return "success";
    }


/*
    @ModelAttribute
    public Student showModel(String username, Integer age) {
        System.out.println(username + " => " + age);
        Student student = new Student();
        student.setAge(age);
        student.setUsername(username);
        // 模拟通过查询数据库操作，将password这个字段的值补全
        student.setPassword("admin123");
        return student;
    }
*/

    @ModelAttribute
    public void showModel(String username, Integer age, Map<String, Object> map) {
        //System.out.println(username + " => " + age);
        Student student = new Student();
        student.setAge(age);
        student.setUsername(username);
        // 模拟通过查询数据库操作，将password这个字段的值补全
        student.setPassword("admin125");
        map.put("student", student);
    }


    @RequestMapping("/showStudent")
    public String showStudent(@ModelAttribute("student") Student student) {
        System.out.println("showStudent is running");
        System.out.println(student);
        return "success";
    }

    @RequestMapping("testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") Integer id,
                                   @PathVariable("username") String username) {
        System.out.println(id + " => " + username);
        return "success";
    }

    @RequestMapping("/testMatrixVariable/{id}")
    public String testMatrixVariable(@PathVariable("id") Integer id,
                                     @MatrixVariable("name") String name,
                                     @MatrixVariable("ages") List<Integer> ages) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(ages);
        return "success";
    }

    // 测试控制器方法的返回值是void
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            System.out.println("testVoid is running");
/*
            // 实现转发效果
            httpServletRequest.getRequestDispatcher("/pages/success.jsp").forward(httpServletRequest, httpServletResponse);
*/

            // 实现重定向效果
            httpServletResponse.sendRedirect("/pages/success.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 测试返回值是ModelAndView
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        // 向作用域中存储数据
        modelAndView.addObject("username", "jia");
        // 转发效果, 设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    // 测试request作用域传值
    @RequestMapping("/testRequest")
    public void testRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletRequest.setAttribute("username", "jia");
            httpServletRequest.getRequestDispatcher("/pages/success.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 使用Map集合进行作用域对象传值
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("username", "jiayi");
        return "success";
    }

    // 使用Model对象进行域对象的传值
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("username", "jiayi");
        return "success";
    }

    @RequestMapping("/toSuccess")
    public String toSuccess() {
        return "success";
    }

    // 使用forward关键字实现转发效果
    @RequestMapping("/testForward")
    public String testForward() {
        //return "forward:/pages/success.jsp";
        return "forward:/demo1/toSuccess";
    }

    // 使用redirect关键字实现重定向
    @RequestMapping("/testRedirect")
    public String testRedirect() {
        //return "redirect:/pages/success.jsp";
        return "redirect:/demo1/toSuccess";
    }
}

