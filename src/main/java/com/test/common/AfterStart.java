package com.test.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by rmiao on 4/19/2016.
 */
@Component
@Order(1)
class AfterStart implements CommandLineRunner {

    public void run(String... strings) throws Exception {
        System.out.println("================after 1==============");
        System.out.println(1);
        System.out.println("==============================");
    }
}
