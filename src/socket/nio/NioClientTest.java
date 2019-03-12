package socket.nio;

import java.nio.ByteBuffer;
/**
 * NIO客户端
 * 
 * @author looly
 * @since 4.4.5
 */
public class NioClientTest {

	/***
	 *获取通道
	 *切换非阻塞模式
	 *分配指定大小的缓冲区
	 *发送数据给服务端
	 **/
	public static void main(String[] args) throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		NioClient nioClient = new NioClient("127.0.0.1",1111);
		nioClient.write(byteBuffer,"Hello socker server, I am nio client");
		nioClient.read(byteBuffer);
		String str = new String(byteBuffer.array());
		System.out.println("Client received:\t" + str);
		nioClient.getChannel().close();
	}
}
