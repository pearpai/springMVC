package com.bq.controller.demo;

import com.bq.entity.User;
import com.bq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class DemoController {

    private Logger logger = LogManager.getLogger("mylog");
    private Logger logger2 = LogManager.getLogger(DemoController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public User userInfo(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return userService.select(1);
    }

    @PostConstruct
    public void  init(){
        System.out.println("I'm  init  method  using  @PostConstrut....");
    }


}