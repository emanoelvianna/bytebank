package com.bytebank.service;

import com.bytebank.model.Acount;

import java.math.BigDecimal;

public class AcountService {
    public BigDecimal deposit(Acount acount, BigDecimal value) {
        BigDecimal result = acount.getBalance().add(value);
        acount.setBalance(result);
        return result;
    }

    public BigDecimal withdraw(Acount acount, BigDecimal value) {
        BigDecimal result = acount.getBalance().add(value);
        acount.setBalance(result);
        return result;
    }

}
