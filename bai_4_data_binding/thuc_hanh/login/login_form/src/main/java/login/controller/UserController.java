package login.controller;


import login.model.Login;
import login.model.User;
import login.service.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute Login login) {
        User user = UserDao.checkLogin(login);
        if (user == null) {
            return new ModelAndView("error", "error", "User name or password incorrect. Enter again.");
        } else {
            return new ModelAndView("user", "user", user);
        }
    }
}
