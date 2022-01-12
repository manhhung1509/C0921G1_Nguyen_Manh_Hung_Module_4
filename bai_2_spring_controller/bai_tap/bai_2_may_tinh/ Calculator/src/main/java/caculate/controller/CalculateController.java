package caculate.controller;

import caculate.service.CalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
   @GetMapping("")
    public String showForm(){
       return "index";
   }

    @GetMapping("/showForm")
    public String showFormHaveUrl(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, @RequestParam(required = false) String firstOperand, @RequestParam(required = false) String secondOperand, @RequestParam(required = false) String operator){
       try{
           float first = Integer.parseInt(firstOperand);
           float second = Integer.parseInt(secondOperand);
           char opera = operator.charAt(0);
           float result = CalculateService.calculate(first, second, opera);
           model.addAttribute("result",result);
       }catch (NumberFormatException e){
           model.addAttribute("Error","enter number");
       }catch(Exception e){
            model.addAttribute("Error",e.getMessage());
        }
        return "index";
    }
}
