package com.test.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by rmiao on 10/8/2016.
 */
public class ResourceFormat extends ResourceBundleMessageSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFormat.class);

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

    /**
     * customized the default message, change it to en_US.
     * @param code
     * @param locale
     * @return
     */
    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {

        MessageFormat messageFormat = super.resolveCode(code, locale);
        if (messageFormat == null ){
            LOGGER.info("Not found the key in zh_CN.");

            messageFormat = super.resolveCode(code, Locale.US);
        }

        Assert.notNull(messageFormat );


        return messageFormat;
    }

}
