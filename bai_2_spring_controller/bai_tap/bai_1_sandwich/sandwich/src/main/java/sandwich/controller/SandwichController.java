package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {

    @GetMapping("")
    public String formCheckBox() {
        return "index";
    }

    @PostMapping("/save")
    public String save(Model model, @RequestParam(required = false) String[] condiment) {
        if (condiment == null) {
            model.addAttribute("element", "please choose");
        }
        model.addAttribute("condiment", condiment);
        return "index";
    }
}
