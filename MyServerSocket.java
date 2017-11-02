import java.lang.*;
import java.io.*;
import java.net.*;

class MyServerSocket{

	ServerSocket s;

	public MyServerSocket(){
		try{
			this.s = new ServerSocket();
		}catch(Exception e){
			System.out.println(e);
		}
	}



}