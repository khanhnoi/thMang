package TH2bai3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ChatRoom extends JFrame implements ActionListener, KeyListener, Runnable{
	JButton send;
	JTextArea sms;
	JTextField chat;
	Login login;
	String name;
	DatagramSocket ds;
	DatagramPacket dp;
	public ChatRoom(){
		setTitle("");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0,5));
        setLocationRelativeTo(null);
        
        JPanel top= new JPanel();
        top.add(new JLabel("Message: "));
        add(top, BorderLayout.NORTH);
        
        sms= new JTextArea(5, 10);
        sms.setLineWrap(true);
        sms.setWrapStyleWord(true);
        sms.setEditable(false);
        JScrollPane sp2= new JScrollPane(sms);
        sp2.setAutoscrolls(true);
        add(sp2, BorderLayout.CENTER);
        
        JPanel bottom= new JPanel();
        bottom.setLayout((LayoutManager) new FlowLayout(FlowLayout.LEFT, 0, 5));
        bottom.add(new JLabel("Send SMS to all users: "));
        chat= new JTextField(28);
        chat.addKeyListener(this);
        bottom.add(chat);
        send= new JButton("Send");
        send.addActionListener(this);
        bottom.add(send);
        add(bottom, BorderLayout.SOUTH);

        
        setVisible(false);
        
        login= new Login(this);
	}
	@Override

//Hàm xử lý sự kiện
	public void actionPerformed(ActionEvent e) {
		Object click= e.getSource();
		if(click==login.login){
			if((name= login.getUserName()).equals("register")){
				login.setReport("Loi");
				return;
			}
			String reg= "register:"+name;
           try {
	        	ds= new DatagramSocket();
	        	dp= new DatagramPacket((reg).getBytes(), reg.length(), InetAddress.getByName("localhost"), 999);
	        	ds.send(dp);
	        }catch(Exception ex){
	        	login.setReport("Loi");
	        }
			login.dispose();
			this.setVisible(true);
			this.setTitle(name);
			new Thread(this).start();
		}else if(click==send){
			try {
				String sms= name+":"+chat.getText();
				dp= new DatagramPacket(sms.getBytes(), sms.length(), InetAddress.getByName("localhost"), 999);
				ds.send(dp);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			chat.setText("");
		}
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		Component c = ke.getComponent();
		if (c == chat) {
            if (ke.getKeyCode() == 10){
            	try {
    				String sms= name+":"+chat.getText();
    				dp= new DatagramPacket(sms.getBytes(), sms.length(), InetAddress.getByName("localhost"), 999);
    				ds.send(dp);
    			} catch (IOException ex) {
    				ex.printStackTrace();
    			}
            	chat.setText("");
            }
        }
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String []args){
		new ChatRoom();
	}
	@Override
//Tiến trình nhận và hiển thị sms
	public void run() {
		try {
			while(true){
				ds.receive(dp);
				String sms= new String(dp.getData()).substring(0, dp.getLength());
				this.sms.append(sms+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
