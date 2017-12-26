import java.lang.*;
import java.nio.*;
import java.util.*;
import java.net.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class ServiceNIO implements Runnable{
	SocketChannel sc;
    String currentNick;
    ServerNIO serv;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public ServiceNIO(SocketChannel s, String nick, ServerNIO serv) {
        this.sc = s;
        this.currentNick = nick;
        this.serv = serv;
    }

    @Override
    public void run() {
        try {            
            ByteBuffer out = ByteBuffer.allocate(2048);
            while (true) {
                ByteBuffer line = ByteBuffer.allocate(2048);
                int read = sc.read(line);

                if(read==-1) break;

                Set<String> keySet = this.serv.llista.keySet();
                for (String nick : keySet){
                    if(!nick.equals(currentNick)){
                        SocketChannel scc = this.serv.llista.get(nick);
                        String linia = RED + currentNick + "-> " + RESET + line; 
                        out = ByteBuffer.wrap(linia.getBytes());
                        scc.write(out);

                    }else {
                        String linia = YELLOW + currentNick + "-> " + RESET + line;
                        out = ByteBuffer.wrap(linia.getBytes());
                        sc.write(out);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}