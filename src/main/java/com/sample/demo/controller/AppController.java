package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@EnableAutoConfiguration
@PropertySource(value =  "classpath:jdbc.properties",ignoreResourceNotFound=true)
@PropertySource(value = "classpath:wsdl.properties",ignoreResourceNotFound=true)

public class AppController {
 
 @Autowired
 private Environment env;
 
 @GetMapping("/")
 public String getPropertyValue()
 {
    return "jdbc.driverClassName:" + env.getProperty("jdbc.driverClassName");
 }

 @GetMapping("/property")
 public String getPropertyValue(@RequestParam("key") String key)
 {
  String returnValue = "No value";
  
  String keyValue = env.getProperty(key);
  
  if( keyValue!= null && !keyValue.isEmpty())
  {
   returnValue = keyValue;
  }
  return returnValue;
 }
}


