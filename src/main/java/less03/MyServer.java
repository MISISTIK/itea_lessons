package less03;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyServer extends Thread {
	Socket s;
	int num;

	public MyServer(Socket s, int num) {
		this.s = s;
		this.num = num;
		start();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		int num = 1;
		ServerSocket ss = new ServerSocket(3134, 0, InetAddress.getByName("172.17.13.195"));
		System.out.println("Server started");
		while (true) {
			new MyServer(ss.accept(), num++);
			System.out.println("Connections: "+num);
		}
	}
	@Override
	public void run() {
			try {
				InputStream is=s.getInputStream();
				OutputStream os=s.getOutputStream();
				byte[] buff=new byte[1024];
				int r=is.read(buff);
				String data=new String(buff,0,r);
				System.out.println(data);
				data="Server received client data: "+data;
				
				os.write(data.getBytes());
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
