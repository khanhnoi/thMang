package TH1bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public Client(){
		try{
			Scanner sc= new Scanner(System.in);
			Socket s= new Socket("localhost", 9999);
			DataOutputStream dos= new DataOutputStream(s.getOutputStream());
			DataInputStream dis= new DataInputStream(s.getInputStream());
			String str="";
			while(true){
				System.out.print("Nhap bieu thuc can tinh: ");
				str= sc.nextLine();
				if(str.equals("exit")) break;
				dos.writeUTF(str);
				System.out.println("Gia tri: "+dis.readUTF());
			}
			s.close();
		}catch(Exception ex){
			
		}
	}
	
	public static void main(String []args){
		new Client();
	}
}
