package convert.coltroller;

import convert.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {
    @Autowired
    ConvertService convertService;

    @GetMapping("")
    public String showForm() {
        return "home";
    }

    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam int usd) {
        int vnd = convertService.convert(usd);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("usd" ,usd);
        modelAndView.addObject("vnd" ,vnd);
        return modelAndView;
    }
}
