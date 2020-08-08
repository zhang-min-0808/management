package com.a.b.c.controller;

import com.a.b.c.dao.ConnectTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class TestController {
    @Autowired
    private ConnectTestDao testDao;

    @RequestMapping("/testConn")
    public ModelAndView testConn(ModelAndView modelAndView){
        List<String> list=testDao.getCity();
        StringBuilder sb=new StringBuilder();
        for(String str:list){
            sb.append(str).append("\r\n</br>");
        }
        modelAndView.addObject("citys",sb.toString());
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
