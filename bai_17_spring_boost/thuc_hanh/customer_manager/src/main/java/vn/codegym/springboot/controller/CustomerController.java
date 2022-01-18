package vn.codegym.springboot.controller;

import vn.codegym.springboot.model.Customer;
import vn.codegym.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ModelAndView showList(){
        Iterable<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/home");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "create customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Integer id){
        Optional<Customer> customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("customer/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete (Customer customer, RedirectAttributes redirectAttributes){
        Integer id = customer.getId();
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("success", "delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdate(@PathVariable Integer id){
        Optional<Customer> customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Integer id){
        Optional<Customer> customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("customer/view");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

}
