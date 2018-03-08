package com.phamluu.main;  
  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
@SpringBootApplication(scanBasePackages={"com.phamluu.ws"})  
public class SpringBootExample {  
    public static void main(String[] args) {  
        SpringApplication.run(SpringBootExample.class, args);  
    }
    
    
    
}  