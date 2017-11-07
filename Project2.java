import java.lang.*;
import java.net.*;
import java.io.*;

class Project2{
	public static void main(String[] args){
		// Client: -c IP port
		// Server: -s port
		String type = args[0];
		String ip = "0.0.0.0";
		String port = "2345";

		if(type.equals("-c")){
			System.out.println("Client");
			ip = args[1];
			port = args[2];

		}else if(type.equals("-s")){
			System.out.println("Server");
			

			while(){

			}
			port = args[1];
		}else{
			System.out.print("Usage: \r\n Server: java Project2 -s Port\r\n  Client: java Project2 -c ipAddress Port\r\n");
		}	
	}
}