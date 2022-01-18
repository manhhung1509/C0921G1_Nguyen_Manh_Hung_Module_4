package vn.codegym.product_manager.controller;

import vn.codegym.product_manager.model.Product;
import vn.codegym.product_manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ModelAndView showList(){
        Iterable<Product> productList = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/home");
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "create product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable Integer id){
        Optional<Product> customer = productService.finById(id);
        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("product", customer);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete (Product product, RedirectAttributes redirectAttributes){
        Integer id = product.getId();
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success", "delete product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdate(@PathVariable Integer id){
        Optional<Product> product = productService.finById(id);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "update product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(String name){
        Iterable<Product> productList = productService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("product/home");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

}
