package socket.bio.trans03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @auth hucc
 * @date 2015年10月10日
 */
public class WeatherClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;

    public static void main(String[] args) {

        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket(HOST, PORT);

            //给服务端发送请求
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String request = "北京";
            dataOutputStream.writeUTF(request);

            dataInputStream = new DataInputStream(socket.getInputStream());
            String response = dataInputStream.readUTF();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(dataInputStream != null){
                    dataInputStream.close();
                }
                if(dataOutputStream != null){
                    dataOutputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}