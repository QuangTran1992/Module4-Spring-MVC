package com.cg.controller;


import com.cg.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public ModelAndView getList(){
        ModelAndView modelAndView = new ModelAndView("/books/home");
        modelAndView.addObject("books",bookService.findAll());
        return modelAndView;
    }

}
