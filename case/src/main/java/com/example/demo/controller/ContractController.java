package com.example.demo.controller;

import com.example.demo.dto.ContractDto;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import com.example.demo.model.service.Services;
import com.example.demo.service.contract.IContractService;
import com.example.demo.service.customer.ICustomerService;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = {"/contract"})
public class ContractController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private IContractService contractService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IServiceService serviceService;

    @ModelAttribute(value = "customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }
    @ModelAttribute(value = "employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute(value = "services")
    public Iterable<Services> services() {
        return serviceService.findAll();
    }

    @GetMapping(value = {"/create-contract"})
    public ModelAndView showCreateContract() {
        ContractDto contractDto = new ContractDto();
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDto", contractDto);
        return modelAndView;
    }

    @PostMapping(value = "/create-contract")
    public ModelAndView saveContract(@Validated @ModelAttribute ContractDto contractDto, BindingResult bindingResult,String content) throws MessagingException {
        new ContractDto().validate(contractDto, bindingResult);

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/contract/create");
            return modelAndView;
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contractService.save(contract);
            sendMail(contractDto);
            ModelAndView modelAndView = new ModelAndView("/contract/create");
            modelAndView.addObject("mes", "new contract created successfully");
            return modelAndView;
        }

    }

    void sendMail(ContractDto contractDto) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        message.setSubject("CREATE CONTRACT SUCCESSFULLY!");
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true);
        helper.setFrom("hung1509nguyenmanh@gmail.com");
        helper.setTo(contractDto.getCustomer().getCustomerEmail());
        helper.setText("<h3 style=\"color: red\">"+"Dear "+contractDto.getCustomer().getCustomerName()+",</h3>\n" +
                            "<h3 style=\"color: green\">Your contract was created successfully!</h3>\n" +
                            "<h4 style=\"color: #14ce14\">Contract information:</h4>\n" +
                            "<p>Contract start date: "+contractDto.getContractStartDay()+"</p>\n" +
                            "<p>Contract end date: "+contractDto.getContractEndDay()+"</p>\n" +
                            "<p>Deposit: "+contractDto.getContractDeposit()+"</p>\n" +
                            "<p>Total Cost: "+contractDto.getContractTotal()+"</p>\n" +
                            "<p>Customer name: "+contractDto.getCustomer().getCustomerName()+"</p>\n" +
                            "<p>Employee name: "+contractDto.getEmployee().getEmployeeName()+"</p>\n" +
                            "<p>Service name: "+contractDto.getService().getServiceName()+"</p>",true);
        javaMailSender.send(message);
    }
}

