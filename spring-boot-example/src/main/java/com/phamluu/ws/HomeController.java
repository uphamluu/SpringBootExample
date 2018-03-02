package com.phamluu.ws;  
import java.sql.Date;
import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class HomeController {  
    @RequestMapping("/hello")  
    public String hello(){
    	
    	Date currentDate= new Date(System.currentTimeMillis());
    	
        return"Hello Uyen! :"+ currentDate.toString()+" " +currentDate.getTime();  
    }  
}  