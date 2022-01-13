package medical_decleration.controller;

import medical_decleration.model.CommonInformation;
import medical_decleration.service.DeclerationSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    DeclerationSerivice declerationSerivice;

    @GetMapping("/home")
    public String showForm(Model model) {
        CommonInformation commonInformation = new CommonInformation();

        model.addAttribute("commonInformation",commonInformation);
        model.addAttribute("yearList",declerationSerivice.getYear());
        model.addAttribute("genderList",declerationSerivice.getGender());
        model.addAttribute("countryList",declerationSerivice.getCountry());
        model.addAttribute("vehicleList",declerationSerivice.getVehicle());
        model.addAttribute("cityList",declerationSerivice.getCity());
        model.addAttribute("districtList",declerationSerivice.getDistrict());
        model.addAttribute("communeList",declerationSerivice.getCommune());
        return "home";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CommonInformation commonInformation, Model model) {

        model.addAttribute("commonInformation",commonInformation);
        model.addAttribute("yearList",declerationSerivice.getYear());
        model.addAttribute("genderList",declerationSerivice.getGender());
        model.addAttribute("countryList",declerationSerivice.getCountry());
        model.addAttribute("vehicleList",declerationSerivice.getVehicle());
        model.addAttribute("cityList",declerationSerivice.getCity());
        model.addAttribute("districtList",declerationSerivice.getDistrict());
        model.addAttribute("communeList",declerationSerivice.getCommune());
        return "home";
    }
}
