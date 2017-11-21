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
                llista.put(ms.getNick(),ms);
                System.out.println("Client with nickname: "+ ms.getNick() +" connection started");
                new Thread(new Service(ms, ms.getNick())).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

