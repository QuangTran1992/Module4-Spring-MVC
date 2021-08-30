package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping("showForm")
    public ModelAndView modelAndView(){
//        ModelAndView modelAndView = new ModelAndView("form");
//        return modelAndView;
        return new ModelAndView("form");
    }

    @PostMapping("caculator")
    public ModelAndView caculator(@RequestParam(name = "number1",required = false) String num1,
                                  @RequestParam(name = "number2",required = false) String num2,
                                  @RequestParam (name = "cal") String cal){
       if(num1 == "" || num2 == ""){
           return new  ModelAndView("form","message","khong the bo trong");
       }else {
           if (!checkNum(num1) || !checkNum(num2)){
               return new  ModelAndView("form","message","Ban da nhap chu. Vui long nhap lai");
           }else {
               double n1 = Double.parseDouble(num1);
               double n2 = Double.parseDouble(num2);
               switch (cal){
                   case "+":
                       return new ModelAndView("form","result",n1+n2);
                   case "-":
                       return new ModelAndView("form","result",n1 - n2);
                   case "*":
                       return new ModelAndView("form","result",n1 * n2);
                   case "/":
                       if(n2 != 0){
                           return new ModelAndView("form","result",n1 / n2);
                       }else {
                           return new  ModelAndView("form","message","Khong the chia 0");
                       }
                   default:
                       return new ModelAndView("404","message","error");

               }

           }
           }

       }

   public boolean checkNum(String strNum){
        if(strNum == null){
            return false;
        }else{
            try{
                Double d = Double.parseDouble(strNum);
            }catch (NumberFormatException e){
                return  false;
            }

        }
        return true;
   }

}
