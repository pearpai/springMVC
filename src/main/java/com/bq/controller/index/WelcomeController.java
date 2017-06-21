package com.bq.controller.index;

import com.bq.entity.User;
import com.bq.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页面
 * Created by wuyunfeng on 2016/10/10.
 */
@Controller
public class WelcomeController {
    private Logger logger = LogManager.getLogger("mylog");
    private Logger logger2 = LogManager.getLogger(WelcomeController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
//        UserInfo userInfo = userService.getUserById(51);
        User user = userService.select(1);

        logger2.info("web------test" + user.getUsername());
//        logger2.error("error-----------~~~~~error");
//        logger2.info("info-----------~~~~~info");

        return "hello";
    }
}
