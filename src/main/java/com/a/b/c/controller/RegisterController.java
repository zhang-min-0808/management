package com.a.b.c.controller;

import com.a.b.c.dao.UserDao;
import com.a.b.c.entity.User;
import com.a.b.c.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/register")
    public String register(@RequestParam String email,@RequestParam String username,@RequestParam String password){
        boolean success=false;
        if(!CommonUtils.isEmpty(username)&& !CommonUtils.isEmpty(password)){
            User user=new User(username,password,email);
            int result=userDao.inert(user);
            success=result>0;
        }
        return success?"redirect:login":"register";

    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        boolean success=false;
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        if(!CommonUtils.isEmpty(username) && !CommonUtils.isEmpty(password)){
            User user=userDao.queryUser(username,password);
            success=user!=null;
            if(success){
                session.setAttribute("username",username);
                session.setAttribute("role",user.getRole());
            }
        }
        return success?"list":"login";
    }

}
