package com.lizba.currency.p3.http;

import java.io.IOException;

/**
 * <p>
 *      启动服务
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/18 21:40
 */
public class TestHttpServer {

    public static void main(String[] args) throws IOException {
        SimplerHttpServer.setBasePath("D:\\test");
        SimplerHttpServer.start();
    }

}
