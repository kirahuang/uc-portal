package com.bestpay.unioncashier.portal.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类注释
 * <p>
 * </p>
 * User: Jiaju Date: 2016/04/28 ProjectName: oms Version: 1.0
 */
@Controller
@Slf4j
@RequestMapping(value = "pages")
public class EntryController {

    @RequestMapping("cancel")
    public ModelAndView cancel(){

        ModelAndView mav=new ModelAndView("cancel");
        return mav;
    }

    @RequestMapping("pay")
    public ModelAndView pay(){
        ModelAndView mav=new ModelAndView("payment");
        return  mav;
    }

    @RequestMapping("refund")
    public ModelAndView refund(){
        ModelAndView mac=new ModelAndView("refund");
        return  mac;
    }

    @RequestMapping("query")
    public ModelAndView query(){
        ModelAndView mac=new ModelAndView("query");
        return  mac;
    }

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mac=new ModelAndView("index");
        return  mac;
    }

}
