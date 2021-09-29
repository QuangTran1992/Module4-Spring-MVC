package com.codegym.controller;


import com.codegym.model.Order;
import com.codegym.model.Shop;
import com.codegym.model.shopDTO.OrderResult;
import com.codegym.service.IOrderService;
import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shops")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @Autowired
    private IOrderService orderService;



    @GetMapping("")
    public ModelAndView getOrdersList() {
        ModelAndView modelAndView = new ModelAndView("/shops/home");
        List<OrderResult> orderList = orderService.getOrders();
        modelAndView.addObject("orders", orderList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/shops/create");
        modelAndView.addObject("orders", new Order());

        return modelAndView;
    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public ModelAndView save(@Validated @ModelAttribute("orders") Order order, BindingResult
            bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("/shops/create");
            modelAndView.addObject("error", "Invalid Value");
            modelAndView.addObject("success",null);

        } else {
            order.setTotal(order.getDeliverFee().add(order.getProductPrice()));
            orderService.save(order);
            redirectAttributes.addFlashAttribute("success", "Successfully added new order");

            modelAndView.setViewName("redirect:/shops");
        }
        return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/shops/edit");
            modelAndView.addObject("order", order.get());
            modelAndView.addObject("success", null);
            modelAndView.addObject("error",null);
            return modelAndView;

        } else {
            return new ModelAndView("/error-404");

        }

    }

    @PostMapping(value = "/edit/{id}",produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView updateOrder(@Validated @ModelAttribute("order") Order order,
                                   BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();

//        if(bindingResult.hasFieldErrors()) {
//            modelAndView.setViewName("/shops/edit");
//
//            modelAndView.addObject("script", true);
//
//        } else {

            orderService.save(order);

            redirectAttributes.addFlashAttribute("success", "Order updated successfully");
            modelAndView.setViewName("redirect:/shops");
//        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);

        if(order.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/shops/delete");
            modelAndView.addObject("order", order.get());

            modelAndView.addObject("success", null);
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }
    @PostMapping("/delete/{id}")
    public ModelAndView deleteOrder(@PathVariable Long id,  RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();

        Optional<Order> order = orderService.findById(id);

        if (order.isPresent()) {
            orderService.remove(id);
            redirectAttributes.addFlashAttribute("success", "Order delete successfully");
            modelAndView.setViewName("redirect:/shops");

            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }



    }

