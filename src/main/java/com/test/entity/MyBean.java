package com.test.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * test get property
 * Created by rmiao on 4/19/2016.
 */
//@Component
public class MyBean {



    @Value("${bean.username}")
    String username;


    @Value("${bean.birth}")
    String birth;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }


    @Override
    public String toString() {
        return "MyBean{" +
                "username='" + username + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
