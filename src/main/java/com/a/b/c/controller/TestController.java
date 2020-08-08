package com.a.b.c.controller;

import com.a.b.c.dao.ConnectTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TestController {
    @Autowired
    private ConnectTestDao testDao;

    @RequestMapping("/testConn")
    public String testConn(){
        List<String> list=testDao.getCity();
        StringBuilder sb=new StringBuilder();
        for(String str:list){
            sb.append(str).append("\r\n</br>");
        }
        return sb.toString();
    }
}
