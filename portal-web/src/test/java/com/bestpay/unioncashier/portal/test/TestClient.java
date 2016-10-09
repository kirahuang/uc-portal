package com.bestpay.unioncashier.portal.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bestpay.unioncashier.portal.web.controller.util.JsonConverter;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext.xml")
public class TestClient  {
    @Autowired
    protected ApplicationContext ctx;
    
    String merchant_id = "20000146";//20000000
    
   List<String> payll = new ArrayList<>();
    
    @SuppressWarnings("serial")
    @Test
    public void payClient() throws Exception {
        
       main();
        
    }
   
    @SuppressWarnings("resource")
    void main(){
        System.out.println("####################请选择业务类型#####################");
        System.out.println("1.pay");
        System.out.println("2.cancel");
        System.out.println("3.refund");
//        System.out.println("4.query");
        Scanner sc11 = new Scanner(System.in);
        String s11 = sc11.nextLine();
        if(s11.trim().equals("1")){
            pay();
        }else if(s11.trim().equals("2")){
            cacenl();
        }else if(s11.trim().equals("3")){
            refund();
        }else{
            System.out.println("####################选择错误#####################");
        }
        
    }
    @SuppressWarnings({ "resource", "serial" })
    void refund(){
        OrderControllerHelper2 service =  ctx.getBean("orderControllerHelper2",OrderControllerHelper2.class); 
        
        
        for(int i=0;i<100;i++){
            System.out.println("####################退款列表或选择m#####################");
            for (int ii=0;ii<payll.size();ii++) {
                System.out.println(ii+"."+payll.get(ii));
            }
            
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if(s.equals("m")){
                main();
            }
            System.out.println("####################请输入退款金额#####################");
            String s22 = sc.nextLine();
            String oooo = payll.get(Integer.parseInt(s));
            Map<String, String> map =new HashMap<String, String>()
            {
                {
                    
                    
                    put("extend_params", "20161009153026087");
                    put("merchant_id", merchant_id);
                    put("operator_id", "M01");
                    put("operator_type", "1");
                    put("out_refund_no", ""+DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()));
                    put("out_trade_no", oooo);
                    put("refund_amount", s22);
                    put("service", "unioncashier.trans.refund");
                    put("sign_type", "MD5");
                    put("version", "V1.0");
                }
            };
            
            
            Map<String, String> mapres = JsonConverter.jsonStringToMap( service.requestToHttpServer(map));
            if(service.validate(mapres)){
               if( mapres.get("is_success").equals("T")&& mapres.get("order_state").equals("SUCCESS")){
                   System.out.println("成功订单>>>>>>>>>>>>>>>"+mapres.get("out_refund_no")+">>>>"+mapres.get("refund_amount"));
                   payll.remove(oooo);
               }
               
                
            }
                
                
                ;
        }
    }
    @SuppressWarnings({ "resource", "serial" })
    void cacenl(){
        OrderControllerHelper2 service =  ctx.getBean("orderControllerHelper2",OrderControllerHelper2.class); 
        
        
        for(int i=0;i<100;i++){
            System.out.println("####################撤销列表或选择m#####################");
            for (int ii=0;ii<payll.size();ii++) {
                System.out.println(ii+"."+payll.get(ii));
            }
            
            
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            
            if(s.equals("m")){
                main();
            }
            String oooo = payll.get(Integer.parseInt(s));
            Map<String, String> map =new HashMap<String, String>()
            {
                {
                    put("extend_params", "20161009151609229");
                    put("merchant_id", merchant_id);
                    put("out_cancel_no", ""+DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()));
                    put("out_trade_no", oooo);
                    put("service", "unioncashier.trans.cancel");
                    put("sign_type", "MD5");
                    put("version", "V1.0");
                }
            };
            
            
            Map<String, String> mapres = JsonConverter.jsonStringToMap( service.requestToHttpServer(map));
            if(service.validate(mapres)){
               if( mapres.get("is_success").equals("T")&& mapres.get("order_state").equals("SUCCESS")){
                   System.out.println("成功订单>>>>>>>>>>>>>>>"+mapres.get("out_cancel_no"));
                   payll.remove(oooo);
               }
               
                
            }
                
                
                ;
        }
    }
    
    
    @SuppressWarnings({ "resource", "serial" })
    void pay(){
        OrderControllerHelper2 service =  ctx.getBean("orderControllerHelper2",OrderControllerHelper2.class); 
        
        
        for(int i=0;i<100;i++){
            System.out.println("####################请付款1分或选择m#####################");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            
            if(s.equals("m")){
                main();
            }
            
            Map<String, String> map =new HashMap<String, String>()
            {
                {
                    put("currency", "156");
                    put("dynamic_id", s);
                    put("extend_params", "20161009141627226");
                    put("merchant_id", merchant_id);
                    put("notify_url", "http,//notify.bestpay.com.cn/nutify_receive.htm");
                    put("operator_id", "M01");
                    put("out_trade_no", ""+DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()));
                    put("product_code", "BARCODE");
                    put("service", "unioncashier.trans.payment");
                    put("sign_type", "MD5");
                    put("store_code", "1233");
                    put("subject", "上海电信网厅");
                    put("terminal_code", "66723764291");
                    put("total_amount", "1");
                    put("version", "V1.0");
                }
            };
            
            
            Map<String, String> mapres = JsonConverter.jsonStringToMap( service.requestToHttpServer(map));
            if(service.validate(mapres)){
               if( mapres.get("is_success").equals("T")&& mapres.get("order_state").equals("SUCCESS")){
                   System.out.println("成功订单>>>>>>>>>>>>>>>"+mapres.get("out_trade_no")+">>>>"+mapres.get("total_amount"));
                   payll.add(mapres.get("out_trade_no"));
               }
               
                
            }
                
                
                ;
        }
    }
}
