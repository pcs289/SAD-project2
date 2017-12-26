import java.lang.*;
import java.nio.*;
import java.io.*;
import java.nio.channels.*;
import java.net.*;
import java.nio.charset.*;


public class ClientNIO implements Runnable{
	
    SocketChannel sc;
	ByteBuffer in, out;
    BufferedReader br_ky;
    
    public ClientNIO(InetAddress ip, int port){
        try{
            this.sc = SocketChannel.open();
            sc.connect(new InetSocketAddress(ip, port));
            System.out.println("Connexio establerta");
            in = ByteBuffer.allocate(2048);
            out = ByteBuffer.allocate(2048);
            new Thread(this).start();
            this.writeToSocket();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            // Output Thread
            while(true){
                int read = sc.read(in);
                if(read==-1) break;
                System.out.println(in.toString());
            }

            this.sc.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeToSocket(){
    	// Input Thread
    	try{
            String linia;
            while ((linia = br_ky.readLine()) != null){
                out = ByteBuffer.wrap(linia.getBytes());
                sc.write(out);
            }   

            this.sc.close();

        }catch(Exception e){
            e.printStackTrace();
        }        
    }
}	