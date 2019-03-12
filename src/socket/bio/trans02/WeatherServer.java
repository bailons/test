package socket.bio.trans02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auth hucc
 * @date 2015年10月10日
 */
public class WeatherServer {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        server = new ServerSocket(PORT);
        System.out.println("天气服务端已经移动，监听端口：" + PORT);
        while(true){
            try {
                socket = server.accept();

                // 接受客户端请求
                dataInputStream = new DataInputStream(socket.getInputStream());
                String request = dataInputStream.readUTF();
                System.out.println("from client..." + request);

                // 响应客户端
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String response = "天气：晴朗，温度：36度";
                dataOutputStream.writeUTF(response);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}