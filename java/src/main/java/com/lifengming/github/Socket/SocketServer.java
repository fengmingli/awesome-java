package com.lifengming.github.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lifengming
 * @date 2021.11.25
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("***服务器即将启动，等待客户端的连接***");
            Socket socket = serverSocket.accept();
            //获取输入流，并读入客户端的信息
            //字节输入流
            InputStream in = socket.getInputStream();
            //把字节输入流转换为字符流
            InputStreamReader inreader = new InputStreamReader(in);
            //为输入流添加缓冲
            BufferedReader br = new BufferedReader(inreader);
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器，客户端说：" + info);

            }
            socket.shutdownInput();//关闭输入流

            //获取输出流，相应客户端的信息
            OutputStream outputStream = socket.getOutputStream();
            //包装为打印流
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您！");
            printWriter.flush(); //刷新缓冲
            socket.shutdownOutput();

            //关闭资源
            printWriter.close();
            outputStream.close();

            br.close();
            inreader.close();
            in.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
