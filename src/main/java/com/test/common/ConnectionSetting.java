package com.test.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * test property bind
 * Created by rmiao on 4/20/2016.
 */
@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionSetting {

    private String username;
    private String password;
    private String remoteAddress;

    @Override
    public String toString() {
        return "ConnectionSetting{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", remoteAddress='" + remoteAddress + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
