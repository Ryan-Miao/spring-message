package com.test;

import com.test.common.ResourceFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by rmiao on 4/18/2016.
 */
@SpringBootApplication // the same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//        sessionLocaleResolver.setDefaultLocale(Locale.US);
//        return sessionLocaleResolver;
//    }

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceFormat();
        source.setBasenames("msg2","msg","locale/test");
        source.setDefaultEncoding("UTF-8");
        source.setFallbackToSystemLocale(false);
        source.setAlwaysUseMessageFormat(true);

        return source;
    }
}
