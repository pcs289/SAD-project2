import java.lang.*;
import java.net.*;
import java.io.*;

class Chat{
	public static void main(String[] args){
		// Client: -c IP port
		// Server: -s port

		if(args.length == 0 || args.length > 3){
			System.out.println("Usage: \r\n Server: java Chat -s Port\r\n  Client: java Chat -c ipAddress Port\r\n");
		}else{
			String type = args[0];
			int ip, port;
			if(type.equals("-c") && args.length == 3){
				System.out.println("Client");
				ip = Integer.parseInt(args[1]);
				port = Integer.parseInt(args[2]);
				System.out.println("Trying to connect at IP " + ip + " at port " + port);

			}else if(type.equals("-s") && args.length == 2){
				System.out.println("Server");
				port = Integer.parseInt(args[1]);
				System.out.println("Waiting for connection at IP " + ip + " at port " + port);
				while(true){
					
				}
				
			}else{
				System.out.println("Usage: \r\n Server: java Chat -s Port\r\n  Client: java Chat -c ipAddress Port\r\n");
			}
		}	
	}
}