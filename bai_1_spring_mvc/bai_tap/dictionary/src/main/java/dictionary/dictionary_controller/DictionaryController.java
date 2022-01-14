package dictionary.dictionary_controller;

import dictionary.service.IsDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    IsDictionary dictionary;

    @GetMapping("")
    public String showForm() {
    return "home";
    }

    @GetMapping("/translate")
    public String showFormHaveUrl() {
        return "home";
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam(required = false, defaultValue = "no word") String word) {
        String mean = dictionary.translate(word);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("mean" ,mean);
        modelAndView.addObject("word" ,word);
        return modelAndView;
    }
}
