package com.bq.controller.index;

import com.bq.entity.CompanyInfo;
import com.bq.service.CompanyInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公司注册
 * Created by wuyunfeng on 2016/10/18.
 */
@Controller
public class CompanyRegisterController {

    private static Logger logger = Logger.getLogger(CompanyRegisterController.class);

    @Autowired
    CompanyInfoService companyInfoService;

    @RequestMapping(value = "/register/companyRegister")
    public String companyRegister(@Valid CompanyInfo companyInfo, BindingResult result, RedirectAttributes redirectAttributes) {
        Map<String, Object> map = new HashMap<>();
        List<CompanyInfo> companyInfos = companyInfoService.getList(map);
        logger.error("=========================");
        companyInfoService.insert(companyInfo);
        return "redirect:/";
    }

}
