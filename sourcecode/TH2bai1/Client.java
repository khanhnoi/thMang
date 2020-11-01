package TH2bai1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {
	
	public final static String SERVER_IP="127.0.0.1";
	public final static int SERVER_POST=7;
	public final static byte[]BUFFER=new byte[4096];
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=null;
		try {
			ds=new DatagramSocket();
			System.out.println("Client started");
			InetAddress address=InetAddress.getByName(SERVER_IP);
			
				System.out.println("Enter message:");
				InputStreamReader in=new InputStreamReader(System.in);
				BufferedReader bf=new BufferedReader(in);
				String str=bf.readLine();
				byte[]data=str.getBytes();
				
				DatagramPacket dp=new DatagramPacket(data,data.length,address,SERVER_POST);
				ds.send(dp);
				
				DatagramPacket incoming=new DatagramPacket(BUFFER, BUFFER.length);
				ds.receive(incoming);
				
				System.out.println("Received:"+new String(incoming.getData()).substring(0,incoming.getLength()));
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ds!=null) {
				ds.close();
				
			}
		}
		
	}
}


