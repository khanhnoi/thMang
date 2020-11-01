package TH1bai2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

public class Server {
	public Server(){
		try{
			ServerSocket ss= new ServerSocket(9999);
			System.out.println("Mo cong 9999 !");
			Socket s= ss.accept();
			System.out.println("Xuat hien ket noi !");
			DataInputStream dis= new DataInputStream(s.getInputStream());
			DataOutputStream dos= new DataOutputStream(s.getOutputStream());
			String str="";
			while(true){
				str= dis.readUTF();
				if(str.equals("exit")) break;
				dos.writeUTF(execute(str));
			}
			s.close();
			ss.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private String getValue(String a, char o, String b){ //Giá trị của một phép toán
		float af= Float.valueOf(a), bf= Float.valueOf(b);
		switch(o){
		case '+': return String.valueOf(af+bf);
		case '-': return String.valueOf(af-bf);
		case '*': return String.valueOf(af*bf);
		case '/':
			if(bf==0) return "error";
			return String.valueOf((float)af/bf);
		default: return "error";
		}
	}
	
	private int prio(char c){ //Tính độ ưu tiên của phép toán
		if(c=='+'||c=='-') return 0;
		if(c=='(') return 1;
		if(c=='*'||c=='/') return 2;
		return -1;
	}
	
	private String execute(String str){ //Tính toán kết quả
		String v="";
		Stack<String> numst= new Stack<String>();
		Stack<Character> opest= new Stack<Character>();
		String num="";
		
		for(int i= 0; i< str.length(); i++){
			char c= str.charAt(i);
			switch(c){
			default:
				return "Error!";
			case '0':case'1':case'2':case '3':case'4':case'5':case'6':case'7':case '8':case'9':case'.':
				num+=c;
				if(i==(str.length()-1)){
					if(!opest.isEmpty()){
						numst.push(getValue(numst.pop(), opest.pop(), num));
						while(!opest.isEmpty()){
							String n2= numst.pop(), n1= numst.pop();
							numst.push(getValue(n1, opest.pop(), n2));
						}
					}else return num;
				}
				break;
			case '+':case'-':
				if(i==0){num+=c; break;}
			case '*':case '/':case '(':
				if(!num.equals("")){
					numst.push(num);
				num="";}
				if(opest.isEmpty()){
					opest.push(c);
				}else{
					if(c=='('){
						opest.push(c);
						break;
					}
	while(!opest.isEmpty()&&(opest.lastElement()!='(')&&prio(c)<=prio(opest.lastElement())){
						String n2= numst.pop(), n1= numst.pop();
						numst.push(getValue(n1, opest.pop(), n2));
					}
					opest.push(c);
				}
				break;
			case ')':
				if(!num.equals("")){
					numst.push(num);
				num="";}
				while((!opest.isEmpty())&&opest.lastElement()!='('){
					String n2= numst.pop(), n1= numst.pop();
					numst.push(getValue(n1, opest.pop(), n2));
				}
				opest.pop();
			}
		}
		while(!opest.isEmpty()){
			String n2= numst.pop(), n1= numst.pop();
			numst.push(getValue(n1, opest.pop(), n2));
		}
		v= numst.pop();
		return v;
	}
	
	public static void main(String[]args){
		new Server();
	}
}

