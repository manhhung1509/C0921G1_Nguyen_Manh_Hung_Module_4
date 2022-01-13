package employee.controller;

import employee.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @GetMapping("/showForm")
    public ModelAndView showForm( ) {
        return new ModelAndView("create", "employee", new Employee());
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee",employee);
        return "info";
    }
}
