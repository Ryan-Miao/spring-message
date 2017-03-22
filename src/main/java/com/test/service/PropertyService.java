package com.test.service;

import com.test.common.Config;
import com.test.common.ConnectionSetting;
import com.test.entity.Language;
import com.test.entity.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * test get property inject
 * Created by rmiao on 4/19/2016.
 */
@Service
public class PropertyService {

    @Autowired
    Config config;

    @Autowired
    Language language;

//    @Autowired
//    MyBean myBean;
//
//    @Autowired
//    MyBean bean2;

    @Autowired
    ConnectionSetting connectionSetting;



//    public MyBean getBean(){
//        System.out.println("The myBean is :"+myBean);
//        return myBean;
//    }
//
//    public MyBean getBean2(){
//        System.out.println("The bean2 is :"+bean2);
//        return bean2;
//    }


    public Config getConfig(){
        System.out.println("The config is:"+config);
        return config;
    }
    public Language getLanguage(){
        System.out.println("The language is:"+language);
        return language;
    }

    public ConnectionSetting getConnectionSetting(){
        System.out.println("The connection is:"+connectionSetting);
        return connectionSetting;
    }

}
