package TH1bai3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class User extends Thread{
	Socket s;
	DataOutputStream dos= null;
	DataInputStream dis= null;
	String name= null;
	public User(Socket s){
		this.s= s;
		try{
			dos= new DataOutputStream(s.getOutputStream());
			dis= new DataInputStream(s.getInputStream());
			name= dis.readUTF();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void run(){
		try{
			while(true){
				String sms= dis.readUTF();
				Main.sms.add(sms);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String getUsername(){
		return name;
	}
	
	public void sendSMS(String str){
		try{
			dos.writeUTF(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}	
	}
}
