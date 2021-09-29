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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList(){
        return new ModelAndView("/customer/list","customers",customerService.findAll());
    }

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
                modelAndView.addObject("customer", customerService.findAll());
                modelAndView.addObject("message" ,"New customer created successfully" );
                return modelAndView ;
            }catch (CustomerException e){
                return new ModelAndView("customer/error");
            }
        }
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        return new ModelAndView("/customer/edit","customer",customerService.findById(id));
    }

    @PostMapping("/edit-customer/{id}")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer,@PathVariable Long id) throws Exception{
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if(customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer" , customer.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("/delete-customer/{id}")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer, @PathVariable Long id ){
       try{
           customerService.remove(id);
           return new ModelAndView("redirect:/customers") ;
       }catch (IllegalArgumentException e){
           return new ModelAndView("/error.404");
       }

    }

    @GetMapping("/deposit-customer/{id}")
    public ModelAndView showDeposit(@PathVariable Long id){
        try{
            Optional<Customer> customer = customerService.findById(id);
            if(customer.isPresent()){
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("/customer/deposit");
                modelAndView.addObject("customer",customer.get());
                return modelAndView;
            }else {
                return new ModelAndView("error.404");
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
            return new ModelAndView("error.404");
        }
    }
    @PostMapping("/deposit-customer/{id}")
    public ModelAndView deposit(@ModelAttribute ("customer") Customer customer, @PathVariable Long id){
        customerService.deposit(customer.getSalary(),id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/deposit");
        modelAndView.addObject("customer",customerService.findById(id));
        modelAndView.addObject("success","Deposit Success!");
        return modelAndView;
    }

    @GetMapping("/withdraw-customer/{id}")
    public ModelAndView showWithdraw(@PathVariable Long id){
        try {
            Optional<Customer> customer = customerService.findById(id);
            if(customer.isPresent()){
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("/customer/withdraw");
                modelAndView.addObject("customer",customer.get());
                return modelAndView;
            }else {
                return new ModelAndView("error.404");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return  new ModelAndView("error.404");

        }
    }

    @PostMapping("/withdraw-customer/{id}")
    public ModelAndView withdraw(@ModelAttribute("customer") Customer customer , @PathVariable Long id){
        customerService.withdraw(customer.getSalary(),id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/withdraw");
        modelAndView.addObject("customer",customerService.findById(id));
        modelAndView.addObject("success", "WithDraw Success !");
        return modelAndView;
    }

}


