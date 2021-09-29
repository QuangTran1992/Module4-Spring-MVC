package com.codegym.service;

import com.codegym.model.LoginParam;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    JwtService jwtService;

    @Override
    public ModelAndView login(LoginParam loginParam, HttpServletResponse response) {
        User user = userRepository.getUserByPhoneNumber(loginParam.getUsername(), loginParam.getPassword());

        ModelAndView modelAndView = new ModelAndView();

        if (user != null) {
            String token = jwtService.generateTokenLogin(user.getPhoneNumber());
            response.addCookie(new Cookie("authorization", token));
            switch (user.getRole()) {

                case ADMIN:
                    modelAndView.setViewName("/admin/home");
                    break;
                case SHOP:
                    modelAndView.setViewName("/shop/home");
                    break;
                case SHIPPER:
                    modelAndView.setViewName("/shipper/home");
                    break;
            }

            return null;
        } else {
            modelAndView.addObject("error","username or password was wrong");
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }
}



