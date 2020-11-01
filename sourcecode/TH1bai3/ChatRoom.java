package TH1bai3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
	Socket s;
	DataOutputStream dos= null;
	DataInputStream dis= null;
	Login login;
	String name;
	public ChatRoom(){
		setTitle("");
        setSize(400, 300);
        setResizable(false);//cho phep thay doi kich thuoc cua so
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0,5));
        setLocationRelativeTo(null);//cua so xuat hien giua man hinh laptop
        
        JPanel top= new JPanel();
        top.add(new JLabel("Tin nhắn"));
        add(top, BorderLayout.NORTH);
        
        sms= new JTextArea(5, 10);
        sms.setLineWrap(true);
        sms.setWrapStyleWord(true);
        sms.setEditable(false);
        JScrollPane sp2= new JScrollPane(sms);
        sp2.setAutoscrolls(true);
        add(sp2, BorderLayout.CENTER);
        
        JPanel bottom= new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        bottom.add(new JLabel("Nội dung tin nhắn: "));
        chat= new JTextField(15);
        chat.addKeyListener(this);
        bottom.add(chat);
        send= new JButton("Gửi");
        send.addActionListener(this);
        bottom.add(send);
        add(bottom, BorderLayout.SOUTH);

        
        setVisible(false);
        
        login= new Login(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object click= e.getSource();
		if(click==login.login){
			name= login.getUserName();
			try{
	        	s= new Socket("localhost", 999);
	        	dos= new DataOutputStream(s.getOutputStream());
	        	dis= new DataInputStream(s.getInputStream());
	        	dos.writeUTF(name);
	        }catch(Exception ex){
	        	login.setReport("Loi");
	        }
			login.dispose();
			this.setVisible(true);
			this.setTitle(name);
			new Thread(this).start();
		}else if(click==send){
			try {
				dos.writeUTF(name+":"+chat.getText());
				chat.setText("");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		Component c = ke.getComponent();
		if (c == chat) {
            if (ke.getKeyCode() == 10){
            	try {
					dos.writeUTF(name+":"+chat.getText());
				} catch (IOException e) {
					e.printStackTrace();
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
	public void run() {
		try {
			while(true){
				sms.append(dis.readUTF()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
