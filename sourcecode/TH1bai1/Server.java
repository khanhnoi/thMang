package TH1bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server(){
		try{
			ServerSocket ss= new ServerSocket(9876);
			//System.out.print("Mo cong 9876 !");
			Socket s= ss.accept();
			System.out.print("server is realdy");
			DataInputStream dis= new DataInputStream(s.getInputStream());
			DataOutputStream dos= new DataOutputStream(s.getOutputStream());
			String str="";
			while(true){
				str= dis.readUTF();
				if(str.equals("exit")) break;
				dos.writeUTF(upCase(str));
				dos.writeUTF(downCase(str));
				dos.writeInt(count(str));
			}
			s.close();
			ss.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	private String upCase(String str){
		byte b[]= str.getBytes();
		for(int i= 0; i< b.length; i++)
			if(b[i]>='a'&&b[i]<='z') b[i]-=32;
		return new String(b);
	}
	
	private String downCase(String str){
		byte b[]= str.getBytes();
		for(int i= 0; i< b.length; i++)
			if(b[i]>='A'&&b[i]<='Z') b[i]+=32;
		return new String(b);
	}
	
	private int count(String str){
		int c=0;
		byte f= 0;
		byte b[]= str.getBytes();
		for(int i= 0; i<b.length; i++){
			if(f==0&&b[i]!=' '){
				f= 1; c+= f;
			}else if(f==1&&b[i]==' ') f= 0;
		}
		return c;
	}
	
	public static void main(String []args){
		new Server();
	}
}
