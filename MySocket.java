import java.lang.*;
import java.io.*;
import java.net.*;

class MySocket{
	
	Socket s;

	//Socket I/O
	PrintWriter out;
	BufferedReader in;

	public MySocket(Socket s){
		this.s = s;
	}

	public MySocket(int ip, int port){
		try{
			this.s = new Socket(ip, port);
			this.out = new PrintWriter(s.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	public InputStream getInputStream(){
		return this.s.getInputStream();
	}

	public OutputStream getOutputStream(){
		return this.s.getOutputStream();
	}
}