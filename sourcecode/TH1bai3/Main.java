package TH1bai3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main extends Thread{
	public static Vector<User> users= new Vector<User>();
	public static Queue<String> sms= new LinkedList<String>();
	ServerSocket ss= null;
	public Main(){
		try{
			ss= new ServerSocket(1239);
		}catch(Exception ex){
		}
		this.start();
		Thread thr= new Thread(){
			public void run(){
				try {
					
					while (true) {
						Thread.sleep(0);
						if(!Main.sms.isEmpty()){	
							String sms = Main.sms.poll();
							for (int i = 0; i < Main.users.size(); i++) {
								User u = Main.users.get(i);
								u.sendSMS(sms);
							}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		};
		thr.start();
	}
	
	public void run(){//Chap nhan ket noi
		try{
			while(true){
				Socket s= ss.accept();
				User u= new User(s);
				u.start();
				System.out.println(u.getUsername()+" da tham gia chat room!");
				users.addElement(u);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String []args){
		new Main();
	}
}
