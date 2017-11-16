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
			int port;
			InetAddress inetAddress;
			if(type.equals("-c") && args.length == 4){	//CLIENT

				System.out.println("Client");
				inetAddress = InetAddress.getByName(args[1]);
				port = Integer.parseInt(args[2]);
				String nick = args[3];
				System.out.println("Trying to connect at IP " + args[1] + " at port " + args[2] + " with nickname " + nick);
				Client client = new Client(inetAddress, port, nick);

			}else if(type.equals("-s") && args.length == 2){	//SERVER

				System.out.println("Server");
				port = Integer.parseInt(args[1]);
				System.out.println("Waiting for connection at port " + port);
				Server serv = new Server(port);
				
			}else{
				System.out.println("Usage: \r\n Server: java Chat -s Port\r\n  Client: java Chat -c ipAddress Port\r\n");
			}
		}	
	}
}