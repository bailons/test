package socket.bio.trans03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WeatherServer {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;
        Socket socket = null;
        server = new ServerSocket(PORT);
        System.out.println("天气服务端已经移动，监听端口：" + PORT);
        while(true){
            socket = server.accept();
            new WeatherThread(socket).start();
        }
    }
}
