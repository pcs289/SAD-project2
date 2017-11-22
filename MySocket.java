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
		// InetAddress ip;
		// try{
		// 	ip = InetAddress.getLocalHost();
		// }catch(Exception e){
		// 	e.printStackTrace();
		// }
		// MySocket(ip, 12345, "Rand");
	}

	public MySocket(InetAddress ip, int port){
		try{
			this.s = new Socket(ip, port);
			this.out = new PrintWriter(s.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	public void connect(){
		try{
			this.s.connect(new InetSocketAddress(this.s.getInetAddress(), this.s.getPort()));
		}catch(Exception e){
			e.printStackTrace();

		}
	}

	public void close(){
		try{
			this.s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public InputStream getInputStream(){
		InputStream in = null;
		try{
			in = this.s.getInputStream();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return in;
		}
	}

	public OutputStream getOutputStream(){
		OutputStream out = null;
		try{
			out = this.s.getOutputStream();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return out;
		}
	}
}