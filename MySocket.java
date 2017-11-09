import java.lang.*;
import java.io.*;
import java.net.*;

class MySocket{
	
	Socket s;

	//Socket I/O
	PrintWriter out;
	BufferedReader in;


	public MySocket(Socket s){
		try{
			this.s = s;
			this.out = new PrintWriter(s.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}