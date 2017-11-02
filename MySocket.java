import java.lang.*;
import java.io.*;
import java.net.*;

class MySocket{
	
	Socket s;

	//Socket I/O
	PrintWriter pws;
	BufferedReader brs;

	//Client I/O
	PrintWriter pwc;
	BufferedReader brc;

	public MySocket(){
		try{
			this.s = new Socket();

			pws = new PrintWriter(this.s.getOutputStream(), true);
			brs = new BufferedReader(new InputStreamReader(this.s.getInputStream()));

			pwc = new PrintWriter(System.out, true);
			brc = new BufferedReader(new InputStreamReader(System.in));

		}catch(Exception e){
			System.out.println(e);
		}

		
	}
}