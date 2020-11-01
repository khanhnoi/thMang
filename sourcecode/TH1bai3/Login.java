package TH1bai3;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
    private ChatRoom cr;
    private JTextField name;
    public JButton login;
    private JLabel report= new JLabel("");
    public Login(ChatRoom cr){
        this.cr= cr;
        setTitle("Đăng nhập");
        setSize(300, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));
        setLocationRelativeTo(null);
        
        JPanel top = new JPanel();
        top.add(new JLabel("Nhập nickname"));
        add(top);
        
        JPanel middle1= new JPanel();
        name= new JTextField(15);
        middle1.add(name);
        add(middle1);
        
        JPanel middle2= new JPanel();
        middle2.add(report);
        add(middle2);
        
        JPanel bottom= new JPanel();
        login= new JButton("Đăng nhập");
        login.addActionListener(cr);
        bottom.add(login);
        add(bottom);
        
        setVisible(true);
        
        report.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        report.setForeground(Color.RED);
    }
    
    public void setReport(String str){
        report.setText(str);
    }
    
    public String getUserName(){
    	return (name.getText().equals(""))?"Unknow name":name.getText();
    }
}
