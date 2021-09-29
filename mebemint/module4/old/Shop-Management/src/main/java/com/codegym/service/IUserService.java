package com.codegym.service;

import com.codegym.IGeneralService;
import com.codegym.model.LoginParam;
import com.codegym.model.UserResult;
import com.codegym.repository.model.user.User;

import javax.servlet.http.HttpServletResponse;

public interface IUserService {
    String login(LoginParam loginParam, HttpServletResponse response);
}
