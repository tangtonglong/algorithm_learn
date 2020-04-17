package com.netty.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;

/**
 * @author : tangtonglong
 * 2020/4/14 17:08
 * @return
 */
public class BasicBuffer {

    public static void main(String[] args){
        //举例说明buffer
        //创建一个buffer，大小为5 ，即可以放5个int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        BasicBuffer basicBuffer = new BasicBuffer();
        basicBuffer.printInfo(intBuffer);
        //向buffer中存放数据
        for (int i = 0; i < 4; i++) {
            intBuffer.put(i*2);
            basicBuffer.printInfo(intBuffer);
        }
        intBuffer.put(4, 10000);
        basicBuffer.printInfo(intBuffer);
        //如何从buffer读取数据
        //将buffer转换，读写切换
        intBuffer.flip();
        basicBuffer.printInfo(intBuffer);
        int count = 0;
        while (intBuffer.hasRemaining()){
            if (count < 3){
                System.out.println(intBuffer.get());
                basicBuffer.printInfo(intBuffer);
            }else {
                basicBuffer.printInfo(intBuffer);
                break;
            }
            count++;
        }
        intBuffer.compact();
        intBuffer.flip();
        intBuffer.compact();
        System.out.println("a");
        basicBuffer.printInfo(intBuffer);
        intBuffer.put(7);
        intBuffer.flip();
        basicBuffer.printInfo(intBuffer);
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
            basicBuffer.printInfo(intBuffer);
        }
    }

    private void printInfo(Buffer b) {
        StringBuffer sb = new StringBuffer();
        sb.append(getClass().getName()).append(b.hashCode()).append("[pos=").append(b.position()).append(" lim=").append(b.limit())
                .append(" cap=").append(b.capacity()).append("]");
        System.out.println(sb);
    }
}
