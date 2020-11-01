package TH2bai3;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class User{
	InetAddress ia= null;
	int po;
	String name= null;
	DatagramPacket dp;
	public User(InetAddress ia, int po, String name){
		this.ia= ia;
		this.po= po;
		dp= new DatagramPacket(new byte[1024], 1024, ia, po);
		this.name= name;
	}
	
	public String getUsername(){
		return name;
	}
	
	public void sendSMS(String str){
		try{
			dp= new DatagramPacket(str.getBytes(), str.length(), ia, po);
			Main.ds.send(dp);
		}catch(Exception ex){
			ex.printStackTrace();
		}	
	}
}
