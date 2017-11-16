import java.lang.*;
import java.io.*;
import java.net.*;

public class Server{

    ConcurentHashMap llista<String, MySocket>;

	public Server(int port){
        try {

            MyServerSocket mss = new MyServerSocket(port);
            while (true) {
                System.out.println("Esperant connexions...");
                MySocket ms = mss.accept();
                llista.put(ms.getNick(),ms);
                new Thread(new Service(ms)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

