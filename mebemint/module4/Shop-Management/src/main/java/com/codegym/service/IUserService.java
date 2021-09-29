package com.codegym.service;

import com.codegym.model.LoginParam;
import com.codegym.repository.model.user.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


public interface IUserService {
    ModelAndView login(LoginParam loginParam, HttpServletResponse response);
}
