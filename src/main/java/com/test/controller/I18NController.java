package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by rmiao on 3/22/2017.
 */
@Controller
@RequestMapping("/i18n/")
public class I18NController {

    @Autowired
    private MessageSource messageSource;

    /**
     * test the single quote for message format by escape
     * @param locale
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "escape/{name}", method = RequestMethod.GET)
    public Map format(Locale locale,
                        @PathVariable("name") String name){
        Map map = new HashMap();

        String[] arr = {name};
        String message = messageSource.getMessage("user.name", arr, locale);
        String age = messageSource.getMessage("user.age", null, locale);
        map.put("username", message);
        map.put("age", age);
        map.put("test", messageSource.getMessage("test",null, locale));


        return map;
    }

    /**
     * test multiple bundle with the same key.
     * result: get the first hit key from the message order.
     * @param locale
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "conflict/{name}", method = RequestMethod.GET)
    public Map keyConflict(Locale locale,
                      @PathVariable("name") String name){
        Map map = new HashMap();

        String[] arr = {name};
        String message = messageSource.getMessage("user.country", arr, locale);
        map.put("country", message);
        map.put("test", messageSource.getMessage("test",null, locale));


        return map;
    }

    /**
     * Test how the spring handle default properties,
     * That is if zh_CN does not has, how to get default.
     * @param locale
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "default", method = RequestMethod.GET)
    public Map defaultMessageFile(Locale locale, String code){
        Map map = new HashMap();

        String msg = messageSource.getMessage(code, null, locale);
        map.put("test", msg);


        return map;
    }

}
