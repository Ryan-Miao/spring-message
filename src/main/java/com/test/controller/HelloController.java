package com.test.controller;

import com.test.common.Config;
import com.test.entity.MyBean;
import com.test.service.PropertyService;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by rmiao on 4/18/2016.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {

    @Autowired
    PropertyService propertyService;

    @ResponseBody
    @RequestMapping("/")
    public String index(){
        return "how to use json?";
    }

    @ResponseBody
    @RequestMapping("/p")
    public Map<String, Object> msg(){
        Map<String,Object> map = new HashMap<String, Object>();
        //test property inject @Value
//        MyBean myBean = propertyService.getBean();
//        map.put("myBean",myBean);

        //test @ConfigurationProperties and databind yml
        Config config = propertyService.getConfig();
        map.put("config", config);
        map.put("lang", propertyService.getLanguage());


        //test @ConfigurationProperties and databind properties
        map.put("connection",propertyService.getConnectionSetting());


        return map;
    }


    @ResponseBody
    @RequestMapping("/json")
    public Map<String,Object> map(ModelMap modelMap, String name){
        modelMap.put("username",12);

        Map<String,Object>  vm = new HashMap<String, Object>();
        String es = StringEscapeUtils.escapeHtml4(name);
        vm.put("username", es);
        return  vm;
    }

    @InitBinder
    public void webInitBinder(WebDataBinder binder){
        System.out.println("webInitBinder:"+binder.getAllowedFields());
//        binder.registerCustomEditor(String.class, StringEscapeUtils.escapeHtml4());
    }


    @RequestMapping(value = "/redirect302", method = RequestMethod.POST)
    public ModelAndView redirect302(String msg){
        return new ModelAndView(new RedirectView("/hello/final?msg="+msg));
    }

    @ResponseBody
    @RequestMapping(value = "/redirect303", method = RequestMethod.POST)
    public ResponseEntity redirect303(HttpServletResponse response, String msg){
        MultiValueMap<String,String> headers = new HttpHeaders();
//        headers.add("Location", "/hello/final?msg="+msg);
        ResponseEntity responseEntity =  new ResponseEntity<String>("body is string", headers, HttpStatus.SEE_OTHER);
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public Map finalpoint(String msg){
        Map map = new HashMap();
        map.put("msg", msg);
        return map;
    }



}
