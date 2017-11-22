import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server{

    ConcurrentHashMap<String, MySocket> llista;

	public Server(int port){
        try {
            this.llista = new ConcurrentHashMap<String, MySocket>();
            MyServerSocket mss = new MyServerSocket(port);
            while (true) {
                MySocket ms = mss.accept();
                PrintWriter outms = new PrintWriter(ms.getOutputStream(), true);
                BufferedReader inms = new BufferedReader(new InputStreamReader(ms.getInputStream()));
                outms.println("Quin nickname vols tenir?");
                String nick = inms.readLine();
                llista.put(nick,ms);
                System.out.println("Client with nickname: "+ nick +" connection started");
                new Thread(new Service(ms, nick)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

