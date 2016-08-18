package com.bestpay.unioncashier.portal.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

/**
 * 类注释
 * <p>
 * </p>
 * User: Jiaju Date: 2016/04/28 ProjectName: oms Version: 1.0
 */
@Controller
@RequestMapping(value = "pages")
public class EntryController {

    @RequestMapping("cancel")
    public ModelAndView cancel(){

        ModelAndView mav=new ModelAndView("cancel");
        return mav;
    }

    @RequestMapping("payment")
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
    
    @RequestMapping("prepayment")
    public ModelAndView prepayment(){
        ModelAndView mac=new ModelAndView("prepayment");
        return  mac;
    }
    
    
    @RequestMapping(value="orderSelect")
    public void orderSelect(@RequestParam("type")String type,HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        Map<String, String> map = new HashMap<>();
        
        for (Map.Entry<String, String> entry : OrderController.orderMap.entrySet()) {
            if(type.equals("PAY")){
                if(entry.getValue().indexOf("PAY")!=-1){
                    map.put(entry.getKey(), entry.getValue());
                }
            }else if(type.equals("REFUND")){
                if(entry.getValue().indexOf("REFUND")!=-1){
                    map.put(entry.getKey(), entry.getValue());
                }
            }else if(type.equals("CANCEL")){
                if(entry.getValue().indexOf("CANCEL")!=-1){
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
        
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(JSONObject.toJSONString(map));
        response.getWriter().flush();
       
    }

}
