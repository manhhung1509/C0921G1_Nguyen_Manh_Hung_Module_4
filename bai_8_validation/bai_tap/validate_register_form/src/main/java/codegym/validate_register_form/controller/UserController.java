package codegym.validate_register_form.controller;

import codegym.validate_register_form.dto.UserDto;
import codegym.validate_register_form.model.User;
import codegym.validate_register_form.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegisterForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/register-User")
    public ModelAndView registerUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                                     BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/create");
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return modelAndView;
        }else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.Save(user);
            modelAndView.addObject("userDto", userDto);
            modelAndView.addObject("message", "Register successfully!");
        }
        return modelAndView;
    }


}
