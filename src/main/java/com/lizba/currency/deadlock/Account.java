package com.lizba.currency.deadlock;

import java.math.BigDecimal;

/**
 * <p>
 *      账户类
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/30 14:04
 */
public class Account {

    public String number;
    public BigDecimal balance;

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
