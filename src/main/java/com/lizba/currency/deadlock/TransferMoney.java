package com.lizba.currency.deadlock;

import java.math.BigDecimal;

/**
 * <p>
 *      转账类
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/30 14:07
 */
public class TransferMoney {

    /**
     * 转账方法
     *
     * @param accountFrom       转账方
     * @param accountTo         接收方
     * @param amt               转账金额
     * @throws Exception
     */
    public static void transferMoney(Account accountFrom,
                                     Account accountTo,
                                     BigDecimal amt) throws Exception {

        synchronized (accountFrom) {
            synchronized (accountTo) {
                BigDecimal formBalance = accountFrom.balance;
                if (formBalance.compareTo(amt) < 0) {
                    throw new Exception(accountFrom.number + " balance is not enough.");
                } else {
                    accountFrom.setBalance(formBalance.subtract(amt));
                    accountTo.setBalance(accountTo.balance.add(amt));
                    System.out.println("Form" + accountFrom.number + ": " + accountFrom.balance.toPlainString()
                    +"\t" + "To" +  accountTo.number + ": " + accountTo.balance.toPlainString());
                }
            }
        }
    }


    public static void main(String[] args) {

        Account accountA = new Account("111111", new BigDecimal(10000));
        Account accountB = new Account("2222222", new BigDecimal(10000));

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    transferMoney(accountA, accountB, new BigDecimal(10));
                } catch (Exception e) {
                   return;
                }
            }).start();

            new Thread(() -> {
                try {
                    transferMoney(accountB, accountA, new BigDecimal(10));
                } catch (Exception e) {
                    return;
                }
            }).start();
        }

    }


}
