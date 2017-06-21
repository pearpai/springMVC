package com.bq.controller.index;

import com.bq.entity.User;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * 此处用来存放一些demo
 * Created by wuyunfeng on 2016/10/10.
 */
@Controller
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("user", new User());
        request.setCharacterEncoding("UTF-8");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        logger.error("=========================");
        try {
            if (bindingResult.hasErrors()) {
                return "login";
            }
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
            return "redirect:/";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/login";
    }



}
