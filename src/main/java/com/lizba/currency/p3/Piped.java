package com.lizba.currency.p3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * <p>
 *      管道流
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/16 21:07
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 输入输出流连接（不连接会报错）
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();

        // 输入
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }



    /**
     * 单个字符读取并输出
     *
     */
    static class Print implements Runnable {
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                 while (true) {
                     // 单个字符读取
                    if ((receive = in.read()) != -1){
                        System.out.print((char)receive);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
