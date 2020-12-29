package com.java.se.io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: PeiYiDing
 * @Date: 2020/12/28
 * @Description: com.java.se.io.test
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        // 实例化文件对象
        File file = new File("doc.txt");
        // 整个文件的大小
        long length = file.length();
        // 规定块的大小
        int blockSize = 1024;
        // 文件可以被切分成多少个块
        int size = (int) Math.ceil(length * 1.0 / blockSize);
        System.out.printf("要被切成<%d>个块", size);
        // 定义起始偏移量位0
        int beginPos = 0;
        // 如果实际文件大小大于块的大小,就赋值块的大小, 如果小则赋值文件实际大小
        int actualSize = (int) (blockSize > length ? length : blockSize);

        // 循环文件的块数
        for (int i = 0; i < size; i++) {
            // 每次读取块的时候的起始偏移量
            beginPos = i * blockSize;
            // 如果遍历到最后一个块
            if (i == size - 1) {
                // 返回剩余的文件大小
                actualSize = (int) length;
            } else {
                // 每循环一次都按一块1024读
                actualSize = blockSize;
                // 使用文件大小减去已经读过的块的大小, 给最后一块读起到正确的读的作用
                length -= actualSize;
            }
            System.out.println(i + "--->起始位置是: " + beginPos + "--->读取的大小是: " + actualSize);
            //readSplit(i, beginPos, actualSize);
        }
    }

    public static void readSplit(int i, int beginPos, int actualSize) {
        // 声明randomAccessFile对象
        RandomAccessFile randomAccessFile = null;
        try {
            // 实例化对象
            randomAccessFile = new RandomAccessFile(new File("doc.txt"), "r");
            // 表示从哪个偏移量读取数据
            randomAccessFile.seek(beginPos);
            // 实例化一个bytes数组
            byte[] bytes = new byte[1024];
            // 初始化一个length的变量
            int length = 0;
            // 循环文件可读到的内容
            while ((length = randomAccessFile.read(bytes)) != -1) {
                // 如果实际大小大于长度
                if (actualSize > length) {
                    // 把一块1024的内容打印出来, 使用newString(), 带偏移量和长度的
                    System.out.println(new String(bytes, 0, length));
                    // 减去已读的数据长度
                    actualSize -= length;

                    // 如果实际大小大于长度
                } else {
                    // 把实际大小的内容读出来
                    System.out.println(new String(bytes, 0, actualSize));
                    // 读完全部内容后跳出循环
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
