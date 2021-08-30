
package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class SanwitchController {
    @GetMapping("/sandwich")
    public ModelAndView choose() {
        return new ModelAndView("/formChoose");
    }

    @PostMapping(value = "/save")
    public ModelAndView save(@RequestParam(required=false,name="condiment") String[] condiment) {
//      ModelAndView modelAndView = new ModelAndView("formChoose");
//      modelAndView.addObject("condiment",condiment);
//      return modelAndView;

        if (!Objects.equals(condiment,null)){
                return new ModelAndView("Result", "condiment", condiment);
            }else

        return new ModelAndView("formChoose", "message", "choose again !!");

    }
    }
