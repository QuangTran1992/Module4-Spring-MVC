package com.codegym.service;

import com.codegym.model.LoginParam;
import com.codegym.model.UserResult;
import com.codegym.repository.IUserRepository;
import com.codegym.repository.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;
    @Autowired
    JwtService jwtService;
    @Override
    public String login(LoginParam loginParam, HttpServletResponse response) {
        Optional<User> user = userRepository.getUserByPhoneNumber(loginParam.getPhoneNumber(), loginParam.getPassword());
        if(user.isPresent()){
            String token = jwtService.generateTokenLogin(user.get().getPhoneNumber());
           response.addCookie(new Cookie("authorization",token));
           return  null;
        }else
            return  "Phone number or password invalid";
    }
}
