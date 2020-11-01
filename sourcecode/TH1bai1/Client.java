package TH1bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client(){
		try{
			Scanner sc= new Scanner(System.in);
			Socket s= new Socket("localhost", 9876);
			DataOutputStream dos= new DataOutputStream(s.getOutputStream());
			DataInputStream dis= new DataInputStream(s.getInputStream());
			System.out.println("connect thanh cong");
			String str="";
			while(true){
				System.out.print("Nhap chuoi: ");
				str= sc.nextLine();
				if(str.equals("exit")) break;
				dos.writeUTF(str);
				System.out.println("Hien thi");
				System.out.println("Chuoi hoa: "+dis.readUTF());
				System.out.println("Chuoi thuong: "+dis.readUTF());
				System.out.println("So tu: "+dis.readInt());
			}
			s.close();
		}catch(Exception ex){
			
		}
	}
	public static void main(String []args){
		new Client();
	}
}
