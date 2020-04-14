package com.netty.nio;

import java.nio.IntBuffer;

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

        //向buffer中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i*2);
        }
        //如何从buffer读取数据
        //将buffer转换，读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
