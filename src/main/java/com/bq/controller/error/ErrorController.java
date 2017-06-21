package com.bq.controller.error;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wuyunfeng on 2016/10/10.
 */
public class ErrorController {

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "/error/403";
    }

}
