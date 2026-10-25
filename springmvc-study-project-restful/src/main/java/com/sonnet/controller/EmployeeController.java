package com.sonnet.controller;

import com.sonnet.dao.EmployeeDao;
import com.sonnet.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    EmployeeDao employeeDao;

    // 查询所有员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getEmployeeList(Model model) {
        Collection<Employee> employees = employeeDao.findAll();
        // 将员工信息保存在作用域中
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    // 删除员工信息
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee"; // 重定向到/employee/资源，目的就是将员工信息删除之后，重新加载一次
    }

    // 新增员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    // 回显员工信息
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    // 更新员工信息
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
