package com.codegym.controller;

import com.codegym.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class ShopAndOrderController {

    @Autowired
    private IShopService shopService ;

    @GetMapping
    public ModelAndView showAllOrders() {
        ModelAndView modelAndView = new ModelAndView("/shop-order/list");
       modelAndView.setViewName("/shop-order/list");
        return modelAndView;
    }


}
