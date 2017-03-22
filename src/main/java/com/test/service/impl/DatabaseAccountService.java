package com.test.service.impl;

import com.test.entity.RiskAssessor;
import com.test.service.AccountServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rmiao on 4/18/2016.
 */
@Service
public class DatabaseAccountService implements AccountServce {

    private final RiskAssessor riskAssessor;

    @Autowired
    public DatabaseAccountService(RiskAssessor riskAssessor){
        this.riskAssessor = riskAssessor;
    }

}
