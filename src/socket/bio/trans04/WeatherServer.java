package socket.bio.trans04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WeatherServer {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;
        Socket socket = null;
        server = new ServerSocket(PORT);
        System.out.println("天气服务端已经移动，监听端口：" + PORT);

        //FixedThreadPool最多开启3（参数）个线程，多余的线程会存储在队列中，等线程处理完了
        //再从队列中获取线程继续处理
        Executor executor = Executors.newFixedThreadPool(3);
        while(true){
            socket = server.accept();
            executor.execute(new WeatherThread(socket));
        }
    }
}
