package com.codegym.controller;

import com.codegym.model.LoginParam;
import com.codegym.model.SignUpParam;
import com.codegym.model.UserResult;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login","login",new LoginParam());
        return modelAndView;
    }

    @GetMapping("/admin/login")
    public ModelAndView adminLogin(){
        return new ModelAndView("/login","login",new LoginParam());
    }

    @PostMapping()
    public ModelAndView login(@ModelAttribute("login") LoginParam loginParam, HttpServletResponse response){
        String result = userService.login(loginParam,response);
        ModelAndView modelAndView;
        if(result != null){
             modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }else {
             modelAndView =  new ModelAndView("");
            modelAndView.setViewName("redirect:/shops/home");
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
