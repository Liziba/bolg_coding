package com.lizba.currency.deadlock;

import java.math.BigDecimal;

/**
 * <p>
 * 转账类优化 -> 通过hash算法
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/7/1 13:33
 */
public class TransferMoneyOptimize {

    private static final Object conflictShareLock = new Object();

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

        int accountFromHash = System.identityHashCode(accountFrom);
        int accountToHash = System.identityHashCode(accountTo);

        if (accountFromHash > accountToHash) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    transferMoneyHandler(accountFrom, accountTo, amt);
                }
            }
        } else if (accountToHash > accountFromHash) {
            synchronized (accountTo) {
                synchronized (accountFrom) {
                    transferMoneyHandler(accountFrom, accountTo, amt);
                }
            }
        } else {
            synchronized (conflictShareLock) {
                synchronized (accountFrom) {
                    synchronized (accountTo) {
                        transferMoneyHandler(accountFrom, accountTo, amt);
                    }
                }
            }
        }

    }

    /**
     * 账户金额增加处理
     *
     * @param accountFrom       转账方
     * @param accountTo         接收方
     * @param amt               转账金额
     * @throws Exception
     */
    private static void transferMoneyHandler(Account accountFrom,
                                             Account accountTo,
                                             BigDecimal amt) throws Exception {
        if (accountFrom.balance.compareTo(amt) < 0) {
            throw new Exception(accountFrom.number + " balance is not enough.");
        } else {
            accountFrom.setBalance(accountFrom.balance.subtract(amt));
            accountTo.setBalance(accountTo.balance.add(amt));
            System.out.println("Form" + accountFrom.number + ": " + accountFrom.balance.toPlainString()
                    +"\t" + "To" +  accountTo.number + ": " + accountTo.balance.toPlainString());
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
