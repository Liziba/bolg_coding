package com.lizba.currency.p3.http;



import com.lizba.currency.p3.threadpool.DefaultThreadPool;
import com.lizba.currency.p3.threadpool.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>
 * 简单HTTP服务器
 * </p>
 *
 * @Author: Liziba
 * @Date: 2021/6/18 11:47
 */
public class SimplerHttpServer {

    /** 设置线程池的默认大小 */
    private static ThreadPool<HttpRequestHandler> pool = new DefaultThreadPool<>(30);
    /** SimplerHttpServer根路径  */
    private static String basePath;
    /** 端口 */
    private static int port = 8888;
    /** serverSocket */
    private static ServerSocket serverSocket;

    public SimplerHttpServer(int port) {
        if (port < 0) {
            return;
        }
        SimplerHttpServer.port = port;
    }

    /**
     * 设置资源根路径
     *
     * @param basePath
     */
    public static void setBasePath(String basePath) {
        if (basePath == null || "".equals(basePath)) {
            return;
        }
        if (new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimplerHttpServer.basePath = basePath;
        }
    }


    /**
     * 启动web服务
     *
     * @throws IOException
     */
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);

        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            pool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }


    /**
     * 将socket请求封装成一个HttpRequestHandler线程任务，将任务提交给线程池
     *
     */
    static class HttpRequestHandler implements Runnable {

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            BufferedReader reader = null;
            BufferedReader br = null;
            PrintWriter out = null;
            InputStream in = null;
            String line;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                // 计算绝对路径
                String absolutePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                // 图片资源处理，此处只支持jpg
                if (absolutePath.endsWith("jpg")) {
                    in = new FileInputStream(absolutePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int len = 0;
                    while ((len = in.read()) != -1) {
                        baos.write(len);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Liziba");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");

                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    // 其他资源例如HTML文本等资源（此处仅支持HTML文本资源）
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(absolutePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Liziba");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                // 错误提示
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, in, reader, out, socket);
            }
        }

        /**
         * 关闭流
         * @param closeables
         */
        private static void close(Closeable... closeables) {
            if (closeables != null) {
                for (Closeable c : closeables) {
                    try {
                        if (c != null)
                            c.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
