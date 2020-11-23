package com.Qnetty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : tangtonglong
 * 2020/4/14 16:10
 * @return
 */
public class BioServer {


    public static void main(String[] args){


        //思路
        //创建一个线程池，
        //如果有客户端连接，就创建一个线程，与客户端通信
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("start");
            while (true){
                System.out.println("wait for link");
                //有客户端连接，就创建一个线程
                final Socket socket = serverSocket.accept();
                System.out.println("cllient linked");
                newCachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        //与客户端通信
                        handler(socket);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handler(Socket socket){
        try {
            System.out.println("thread info:" + Thread.currentThread().getName() + " Id:" + Thread.currentThread().getId());
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            //循环读取client发送的数据
            while (true){
                System.out.println("reading ....");
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(new String(bytes, 0, read));
                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("shut down socket");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
