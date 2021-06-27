package com.lizba.currency.p3.sqlpoo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 数据库连接驱动
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/17 16:57
 */
public class ConnectionDriver {

    private static final String COMMIT_OP = "commit";

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // commit 时睡眠200ms
            if (method.getName().equals(COMMIT_OP)) {
                TimeUnit.MILLISECONDS.sleep(200);
            }
            return null;
        }
    }

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                new Class<?>[] {Connection.class}, new ConnectionHandler());
    }
}
