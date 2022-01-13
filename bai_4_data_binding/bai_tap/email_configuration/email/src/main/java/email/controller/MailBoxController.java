package email.controller;

import email.model.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MailBoxController {

    @GetMapping("/showList")
    public ModelAndView ShowList(){
        String [] languageList = {"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = {5, 10, 15, 25, 50, 100};
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("mail",new Mailbox("English", 25, false, "Thor King, Asgard"));
        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject("pageSizeList",pageSizeList);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateMailBox(@ModelAttribute Mailbox mail){
        String [] languageList = {"English", "Vietnamese", "Japanese", "Chinese"};
        Integer [] pageSizeList = {5, 10, 15, 25, 50, 100};
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("mail",mail);
        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject("pageSizeList",pageSizeList);
        return modelAndView;

        //được 1 object nên e làm ri thôi cho nhanh nghe a Chiến. tạo service vs repository mất tg.
    }
}
