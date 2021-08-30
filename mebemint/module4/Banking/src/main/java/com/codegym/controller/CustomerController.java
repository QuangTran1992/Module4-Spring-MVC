package com.codegym.controller;


import com.codegym.exception.CustomerException;
import com.codegym.model.Customer;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/customer/create","customer", new Customer());
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@Validated @ModelAttribute("customer") Customer customer , BindingResult bindingResult) throws CustomerException {
        if(bindingResult.hasFieldErrors()){
            return  new ModelAndView("/customer/create");
        }
        else {
            try {
                customerService.save(customer);
                ModelAndView modelAndView = new ModelAndView("/customer/create");
                modelAndView.addObject("customer", new Customer());
                modelAndView.addObject("message" ,"New customer created successfully" );
                return modelAndView ;
            }catch (CustomerException e){
                return new ModelAndView("customer/error");
            }
        }
    }



}
