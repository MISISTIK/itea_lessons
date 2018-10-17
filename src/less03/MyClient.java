package less03;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient{
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s=new Socket(InetAddress.getByName("172.17.13.195"),3134);
		String ss="my message to server";
		s.getOutputStream().write(ss.getBytes());		
		byte[] buff=new byte[1024];
		int r=s.getInputStream().read(buff);
		String data=new String(buff,0,r);
		System.out.println(data);

	}

}
