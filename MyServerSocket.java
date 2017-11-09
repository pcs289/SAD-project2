import java.lang.*;
import java.io.*;
import java.net.*;

class MyServerSocket{

	ServerSocket s;
	
	//Socket I/O
	PrintWriter out;
	BufferedReader in;

	public MyServerSocket(){
		try{
			this.s = new ServerSocket();
			this.out = new PrintWriter(s.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		}catch(Exception e){
			System.out.println(e);
		}
	}

	public MySocket accept() throws IOException{
		Socket s = this.s.accept();
		return new MySocket(s);
	}


}