import java.lang.*;
import java.io.*;
import java.net.*;

class MySocket{
	
	Socket s;

	//Socket I/O
	PrintWriter out;
	BufferedReader in;
	String nick;

	public MySocket(Socket s){
		this.s = s;
	}

	public MySocket(InetAddress ip, int port, String nick){
		try{
			this.s = new Socket(ip, port);
			this.nick = nick;
			this.out = new PrintWriter(s.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	public String getNick(){
		return this.nick;
	}

	public InputStream getInputStream(){
		return this.s.getInputStream();
	}

	public OutputStream getOutputStream(){
		return this.s.getOutputStream();
	}
}