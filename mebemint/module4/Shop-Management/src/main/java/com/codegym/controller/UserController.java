package com.codegym.controller;

import com.codegym.model.LoginParam;
import com.codegym.repository.model.user.User;
import com.codegym.service.IUserService;
import com.codegym.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    JwtService jwtService;

    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("/login", "login", new LoginParam());
        return modelAndView;
    }


    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") LoginParam loginParam, HttpServletResponse response) {
        String result = userService.login(loginParam, response);

        ModelAndView modelAndView;
        if (result != null) {
            modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        } else {
            modelAndView = new ModelAndView("");
            modelAndView.setViewName("redirect:/admin/home");
        }
        return modelAndView;

    }

//    @GetMapping("/signUp")
//    public ModelAndView signUp(){
//        return new ModelAndView("/signUp","signUp",new SignUpParam());
//    }
//
//    @PostMapping()
//    public ModelAndView signUp(@ModelAttribute("signUp") SignUpParam signUpParam){
//        if(user == null){
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }else {
//            ModelAndView modelAndView =  new ModelAndView("/shops/home");
//            modelAndView.addObject("orders",orderService.getOrders());
//            return modelAndView;
//        }
//        return null;
//    }

}
