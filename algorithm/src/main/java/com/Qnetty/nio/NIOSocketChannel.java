package com.Qnetty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOSocketChannel {

    public static void main(String[] args){

        try {
            String str = "lubenweiniubi";
            FileOutputStream fileOutputStream = new FileOutputStream("G:\\xx.txt");
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.write(byteBuffer);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
