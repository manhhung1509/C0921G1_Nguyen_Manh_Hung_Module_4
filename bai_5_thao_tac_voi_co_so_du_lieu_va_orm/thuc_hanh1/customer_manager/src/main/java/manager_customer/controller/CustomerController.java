package manager_customer.controller;

import manager_customer.model.Customer;
import manager_customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ModelAndView showList(){
        List<Customer> customerList = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
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
    public ModelAndView showDelete(@PathVariable Long id){
        Customer customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete (Customer customer, RedirectAttributes redirectAttributes){
        Long id = customer.getId();
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("success", "delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdate(@PathVariable Long id){
        Customer customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
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
    public ModelAndView view(@PathVariable Long id){
        Customer customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @GetMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        List<Customer> customerList = customerService.searchByName(name);
        if (!customerList.isEmpty()){
            model.addAttribute("customerList", customerList);
            return "/home";
        }else {
            model.addAttribute("customerList",customerList);
            model.addAttribute("fail","Customer is not found");
            return "/home";
        }
    }
}
