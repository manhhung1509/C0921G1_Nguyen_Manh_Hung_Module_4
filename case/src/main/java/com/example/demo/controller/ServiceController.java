package com.example.demo.controller;

import com.example.demo.dto.ServiceDto;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service.RentType;
import com.example.demo.model.service.ServiceType;
import com.example.demo.model.service.Services;
import com.example.demo.service.service.IRentTypeService;
import com.example.demo.service.service.IServiceService;
import com.example.demo.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IServiceService serviceService;


    @ModelAttribute(value = "rentTypes")
    public List<RentType> getListRentTpye() {
        return rentTypeService.findAll();
    }

    @ModelAttribute(value = "serviceTypes")
    public List<ServiceType> getListServiceType() {
        return serviceTypeService.findAll();
    }

    @GetMapping(value = "/services")
    public ModelAndView listService(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("service/list");
        Page<Services> services;
        services = serviceService.findAll(pageable);
        modelAndView.addObject("serviceList", services);
        if (pageable.getPageNumber() > services.getTotalPages()){
            return new ModelAndView("/error_404");
        }
        return modelAndView;
    }

    @GetMapping(value = {"/create-service"})
    public ModelAndView showCreateService() {
        ServiceDto serviceDto = new ServiceDto();
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceDto", serviceDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-service")
    public ModelAndView saveService(@Validated @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult) {
        Services services = new Services();
        BeanUtils.copyProperties(serviceDto, services);
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("service/create");
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            serviceService.save(services);
            ModelAndView modelAndView = new ModelAndView("/service/create");
            modelAndView.addObject("services", services);
            modelAndView.addObject("message", "new service created successfully");
            return modelAndView;
        }
    }
}
