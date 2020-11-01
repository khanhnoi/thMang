package TH2bai2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	public Client(){
		try{
			Scanner sc= new Scanner(System.in);
			String str="";
			DatagramSocket ds= new DatagramSocket();
			DatagramPacket dp;
			while(true){
				System.out.print("Nhap bieu thuc can server tinh gia tri: ");
				str= sc.nextLine();
				if(str.equals("exit")) break;

//Gửi biểu thức đến server
				dp= new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 1995);
				ds.send(dp);
				System.out.println("Da gui chuoi !");
				
				String str2;

//Nhận lại giá trị của biểu thức
				ds.receive(dp);
				str2= new String(dp.getData()).substring(0, dp.getLength());
				System.out.println("Gia tri bieu thuc: "+str2);
			}
		}catch(Exception ex){		
		}
	}
	public static void main(String []args){
		new Client();
	}
}
