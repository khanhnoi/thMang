package TH2bai1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {
	public final static int SERVER_PORT=7;
	public final static byte[]BUFFER=new byte[4096];
	public String chuHoa(String s) {
    	s = s.trim();
    	String tam = "";
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c >= 'a' && c <= 'z') c = (char)(c-32);
    		tam += c;
    	}
    	return tam;
    }
	
	public String chuthuong(String s) {
    	s = s.trim();
    	String tam = "";
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(c >= 'A' && c <= 'Z') c = (char)(c+32);
    		tam += c;
    	}
    	return tam;
    }
	
	public int demSoTu(String s) {
		int count = 0;
		try {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == ' ' && s.charAt(i+1) != ' ' && s.charAt(i+1) != '\0') {
					count++;
				}
			}
			if(s.charAt(0) != ' ') count++;
			return count;
		} catch(Exception e) {
			return count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=null;
		Server dt=new Server();
		try {
			ds=new DatagramSocket(SERVER_PORT);
			System.out.println("Server started");
			System.out.println("Waiting  for message from client...");
			
				DatagramPacket incoming=new DatagramPacket(BUFFER, BUFFER.length);
				ds.receive(incoming);
				
				String message=new String(incoming.getData(), 0, incoming.getLength());
				System.out.println("Received: "+message);
				
				String choa=dt.chuHoa(message);

				String cthuong=dt.chuthuong(message);
				
				String sotu=String.valueOf(dt.demSoTu(message));
				
				
				String chuoi="Chu hoa:"+choa
									+" \nChu thuong:"+cthuong
									+" \ndem so tu:"+sotu;
									
				
				System.out.println("Choui da xu ly: "+chuoi);
				
				DatagramPacket outsending=new DatagramPacket(chuoi.getBytes(), chuoi.length()	, incoming.getAddress()	, incoming.getPort());
				ds.send(outsending);
			
		
		
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ds!=null) {
				ds.close();
			}
		}
		
	}

}

