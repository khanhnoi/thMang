package TH2bai3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main extends Thread{
	public static Vector<User> users= new Vector<User>();
	public static Queue<String> sms= new LinkedList<String>();
	public static DatagramSocket ds;
	DatagramPacket dp;
	ServerSocket ss= null;
	public Main(){
		try{
			ds = new DatagramSocket(999);
			dp= new DatagramPacket(new byte[1024], 1024);
		}catch(Exception ex){
		}
		this.start();
	}

//Tiến trình gửi sms cho tất cả các client
		Thread thr= new Thread() {
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
		}.start();
}


//Tiến trình nhận sms từ các client	
	public void run(){//Chap nhan ket noi va lay sms dua vao Queue
		try{
			while(true){
				ds.receive(dp);
				String reg= new String(dp.getData()).substring(0, dp.getLength());
				String []temp= reg.split(":");
				if(temp[0].equals("register")){
					User u= new User(dp.getAddress(), dp.getPort(), temp[1]);
					users.addElement(u);
					System.out.println(u.getUsername()+" da tham gia chat room!");
				}else{
					Main.sms.add(reg);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String []args){
		new Main();
	}
}
