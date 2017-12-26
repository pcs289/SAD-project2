import java.lang.*;
import java.net.*;
import java.nio.*;

class ChatNIO{
	public static void main(String[] args){
		// Client: -c IP port
		// Server: -s port

		if(args.length == 0 || args.length > 3){
			System.out.println("Usage:\r\nServer: java Chat -s Port\r\nClient: java Chat -c ipAddress Port \r\n");
		}else{
			String type = args[0];
			int port;
			InetAddress inetAddress;
			if(type.equals("-c") && args.length == 3){	//CLIENT

				System.out.println("Client");
				try{
					inetAddress = InetAddress.getByName(args[1]);
					port = Integer.parseInt(args[2]);
					System.out.println("Trying to connect at IP " + args[1] + " at port " + args[2]);
					ClientNIO client = new ClientNIO(inetAddress, port);
				}catch(Exception e){
					e.printStackTrace();
				}

			}else if(type.equals("-s") && args.length == 2){	//SERVER

				System.out.println("Server");
				port = Integer.parseInt(args[1]);
				System.out.println("Waiting for connection at port " + port);
				ServerNIO serv = new ServerNIO(port);
				
			}else{
				System.out.println("Usage:\r\nServer: java Chat -s Port\r\nClient: java Chat -c ipAddress Port \r\n");
			}
		}	
	}
}