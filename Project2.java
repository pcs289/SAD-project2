import java.lang.*;
import java.net.*;
import java.io.*;

class Project2{
	public static void main(String[] args){
		// Client: -c IP port
		// Server: -s port
		if(args.length == 0 || args.length > 3){
			System.out.println("Usage: \r\n Server: java Project2 -s Port\r\n  Client: java Project2 -c ipAddress Port\r\n");
		}else{
			String type = args[0];

			if(type.equals("-c") && args.length == 3){
				System.out.println("Client");
				ip = args[1];
				port = args[2];
				System.out.println("Trying to connect at IP " + ip + " at port " + port);

			}else if(type.equals("-s") && args.length == 2){
				System.out.println("Server");
				port = args[1];
				System.out.println("Waiting for connection at IP " + ip + " at port " + port);
				while(true){
					
				}
				
			}else{
				System.out.println("Usage: \r\n Server: java Project2 -s Port\r\n  Client: java Project2 -c ipAddress Port\r\n");
			}
		}	
	}
}