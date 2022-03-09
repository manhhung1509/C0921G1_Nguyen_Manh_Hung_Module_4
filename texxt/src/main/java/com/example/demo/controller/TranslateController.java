package com.example.demo.controller;

import com.example.demo.dto.TranslateDto;

import com.example.demo.model.Customer;
import com.example.demo.model.ServiceType;
import com.example.demo.model.Translate;
import com.example.demo.repository.IServiceTypeRepository;
import com.example.demo.service.IServiceTypeService;
import com.example.demo.service.ITranslateService;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/translate")
public class TranslateController {
    @Autowired
    private ITranslateService translateService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @ModelAttribute(value = "customers")
    public List<Customer> getCustomerList() {
        return customerService.findAll();
    }

    @ModelAttribute(value = "serviceTypes")
    public List<ServiceType> getServiceTypeList() {
        return serviceTypeService.findAll();
    }

    @GetMapping(value = "/translates")
    public ModelAndView listTranslate(@RequestParam("serviceType") Optional<String> serviceType,
                                     @RequestParam("customerName") Optional<String> customerName) {

        ModelAndView modelAndView = new ModelAndView("translate/list");
        List<Translate> translates ;

        if (!serviceType.isPresent() && !customerName.isPresent()){
            translates = translateService.findAll();
            modelAndView.addObject("translates", translates);
        }else {
            translates  = translateService.searchTranslateContaining(serviceType.orElse(""), customerName.orElse(""));
            modelAndView.addObject("translates",translates);
            modelAndView.addObject("customerName",customerName.orElse(""));
            modelAndView.addObject("serviceType",serviceType.orElse(""));
        }
        return modelAndView;
    }

    @GetMapping(value = {"/create-translate"})
    public ModelAndView showCreateTranslate() {
        TranslateDto translateDto = new TranslateDto();
        ModelAndView modelAndView = new ModelAndView("translate/create");
        modelAndView.addObject("translateDto", translateDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-translate")
    public ModelAndView saveTranslate(@Validated @ModelAttribute TranslateDto translateDto, BindingResult bindingResult) {
        new TranslateDto().validate(translateDto,bindingResult);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("translate/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            Translate translate = new Translate();
            BeanUtils.copyProperties(translateDto, translate);
            translateService.save(translate);
            ModelAndView modelAndView = new ModelAndView("/translate/create");
            modelAndView.addObject("translate", translate);
            modelAndView.addObject("message", "new translate created successfully");
            return modelAndView;
        }
    }


    @GetMapping(value = {"/delete-translate/{id}"})
    public ModelAndView showDeleteTranslate(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("translate/table_delete");
        modelAndView.addObject("translate",translateService.findTranslateById(id));
        return modelAndView;
    }

    @PostMapping(value = {"/delete-translate/{id}"})
    public ModelAndView DeleteTranslate(@PathVariable Integer id) {
        Translate translate = translateService.findTranslateById(id);
        translateService.delete(translate);
        List<Translate> translates;
        ModelAndView modelAndView = new ModelAndView("translate/list_copy");
        modelAndView.addObject("translates", translateService.findAll());
        return modelAndView;
    }

}
