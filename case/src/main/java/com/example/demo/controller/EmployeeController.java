package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Division;
import com.example.demo.model.employee.EducationDegree;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import com.example.demo.model.user.Role;
import com.example.demo.model.user.User;
import com.example.demo.service.employee.IDivisionService;
import com.example.demo.service.employee.IEducationDegreeService;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.employee.IPositionService;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @ModelAttribute(value = "positions")
    public List<Position> getListPosition() {
        return positionService.findAll();
    }

    @ModelAttribute(value = "educationDegrees")
    public List<EducationDegree> getListEducationDegree() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute(value = "divisions")
    public List<Division> getListDivision() {
        return divisionService.findAll();
    }

    @GetMapping(value = "/employees")
    public ModelAndView listCustomer(@RequestParam("employeeName") Optional<String> employeeName,
                                     @RequestParam("phone") Optional<String> phone,
                                     @RequestParam("address") Optional<String> address,
                                     @PageableDefault(value = 1) Pageable pageable) {
        ModelAndView  modelAndView = new ModelAndView("employee/list");
        Page<Employee> employees;

        if (!employeeName.isPresent() && !phone.isPresent() && !address.isPresent()){
            employees = employeeService.findAll(pageable);
            modelAndView.addObject("employees",employees );
            if (pageable.getPageNumber() > employees.getTotalPages()){
                return new ModelAndView("/error_404");
            }
        }else {
            employees  = employeeService.searchEmployeeContaining(employeeName.orElse(""), phone.orElse(""),address.orElse(""),pageable);
            modelAndView.addObject("employees",employees);
            modelAndView.addObject("employeeName",employeeName.orElse(""));
            modelAndView.addObject("phone",phone.orElse(""));
            modelAndView.addObject("address",address.orElse(""));
            if (pageable.getPageNumber() > employees.getTotalPages()){
                return new ModelAndView("/error_404");
            }
        }
        return modelAndView;
    }

    @GetMapping(value = {"/create-employee"})
    public ModelAndView showCreateEmployee() {
        EmployeeDto employeeDto = new EmployeeDto();
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", employeeDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-employee")
    public ModelAndView saveEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            User user = new User();
            user.setUsername(employeeDto.getUserName());
            user.setPassword(employeeDto.getPassWord());
            user.setEmployee(employee);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("/employee/create");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "new employee created successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/edit-employee/{id}"})
    public ModelAndView showEditEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findEmployeeById(id);
        if (employee == null){
            return new ModelAndView("error_404");
        }else {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee,employeeDto);
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            modelAndView.addObject("employeeDto", employeeDto);
            return modelAndView;
        }
    }

    @PostMapping(value = "/edit-employee")
    public ModelAndView editCustomer(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("employee/edit");
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("message", "Update employee successfully");
            return modelAndView;
        }
    }

    @GetMapping(value = {"/delete-employee/{id}"})
    public ModelAndView showDeleteEmployee(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("employee/table_delete");
        modelAndView.addObject("employee",employeeService.findEmployeeById(id));
        return modelAndView;
    }

    @PostMapping(value = {"/delete-employee/{id}"})
    public ModelAndView DeleteCustomer(@PathVariable Integer id, @PageableDefault(value = 1) Pageable pageable) {
        Employee employee = employeeService.findEmployeeById(id);
        employeeService.delete(employee);
        Page<Employee> employees;
        ModelAndView modelAndView = new ModelAndView("employee/list_copy");
        modelAndView.addObject("employees", employeeService.findAll(pageable));
        return modelAndView;
    }

}

