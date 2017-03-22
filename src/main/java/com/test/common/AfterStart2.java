package com.test.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by rmiao on 4/19/2016.
 */
@Component
@Order(2)
class AfterStart2 implements CommandLineRunner {

    public void run(String... strings) throws Exception {
        System.out.println("================after 2==============");
        System.out.println(2);
        System.out.println("==============================");
    }
}
