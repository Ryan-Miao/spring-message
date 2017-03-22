package com.test.common;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.io.IOException;
import java.io.Reader;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by rmiao on 10/8/2016.
 */
public class ResourceFormat extends ResourceBundleMessageSource {

    @Override
    protected String getStringOrNull(ResourceBundle bundle, String key) {
        if(bundle.containsKey(key)) {
            try {
                String val = bundle.getString(key);
                return val.replaceAll("'","''");
            } catch (MissingResourceException var4) {
                ;
            }
        }

        return null;
    }

}
