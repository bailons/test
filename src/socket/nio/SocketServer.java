package socket.nio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static int PORT = 1111;

    public static void main(String[] args) {
        System.out.println("服务器启动...");
        SocketServer server = new SocketServer();
        server.init();
    }

    private void init() {
        ServerSocket sock = null;
        try {
            sock = new ServerSocket(PORT);
            //while (true) {
            Socket Client = sock.accept();
            System.out.println("-------------------");
            new HandlerThread(Client);
            //}
        } catch (Exception e) {
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;

        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                //获取字节输入流
                InputStream is = socket.getInputStream();
                //获取字节输出流返回给客户端数据
                OutputStream os = socket.getOutputStream();
                //InputStream(从客户端发送给服务器端的数据流)/OutputStream(发送给客户端的数据)
                //获取消息的长度
                int count = 0;
                byte[] body = null;
                while (count == 0) {
                    count = is.available();
                    if (count > 0) {
                        //读取消息并转为String
                        body = new byte[count];
                        is.read(body);
                        System.out.println("服务端接收数据\t" + new String(body,"GBK"));
                    }
                }
                os.write("hello client,I am socket server".getBytes());
                is.close();
                os.close();
            } catch (EOFException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                    }
                }
            }
        }
    }
}
