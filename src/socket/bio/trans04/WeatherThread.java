package socket.bio.trans04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class WeatherThread extends Thread {

    private Socket socket;

    public WeatherThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            // 接受客户端请求
            dataInputStream = new DataInputStream(socket.getInputStream());
            String request = dataInputStream.readUTF();
            System.out.println("from client..." + request + " 当前线程：" + Thread.currentThread().getName());

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
