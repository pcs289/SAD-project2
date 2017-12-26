import java.lang.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.nio.charset.*;


public class ServerNIO{

    ConcurrentHashMap<String, SocketChannel> llista;
    ServerSocketChannel ssc;

	public ServerNIO(int port){
        try {
            this.llista = new ConcurrentHashMap<String, SocketChannel>();
            ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(port));
            while (true) {
            	SocketChannel sc = ssc.accept();
                String actualNick = this.requestName(sc); 
                this.llista.put(actualNick, sc);             
                System.out.println("Client with nickname: "+ actualNick +" connection started");
                new Thread(new ServiceNIO(sc, actualNick, this)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String requestName(SocketChannel sc){
    	ByteBuffer in, out;
    	ByteBuffer acceptedNick = ByteBuffer.allocate(2048);
    	out = ByteBuffer.allocate(50);

        Boolean check = true;
        Set<String> keys = this.llista.keySet();
        try{
            do{
                String linia = "Quin nickname vols tenir?";
                out = ByteBuffer.wrap(linia.getBytes());
                sc.write(out);
                int read = sc.read(acceptedNick);
                for(String name : keys){
                    if(name.equals(acceptedNick.toString())){
                        String line = "Aquest nick ja esta en us, tria'n un altre!";
                        out = ByteBuffer.wrap(line.getBytes());
            		  sc.write(out);
                        check = false;
                    }else{check = true;}
                }
            }while(!check); 
        }catch(Exception e){
                e.printStackTrace();
         }
        return acceptedNick.toString();
    }
    
}

