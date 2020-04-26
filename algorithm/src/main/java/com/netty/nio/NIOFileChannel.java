package com.netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : ttl
 * 2020/4/15 16:38
 * @return
 */
public class NIOFileChannel {

    public static void main(String[] args) {
        String str = "lbwnb";
        //创建一个输出流
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\xxx.txt");

            //通过 fileOutputStream 获取对应的 filechannel
            FileChannel fileChannel = fileOutputStream.getChannel();
            //创建一个buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(str.getBytes());
            //对buffer进行反转
            byteBuffer.flip();

            fileChannel.write(byteBuffer);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
