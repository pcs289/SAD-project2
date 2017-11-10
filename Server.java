import java.lang.*;
import java.io.*;
import java.net.*;

public class Server{

	public Server(int port){
        try {
            MyServerSocket mss = new MyServerSocket(port);
            while (true) {
                System.out.println("Esperant connexions...");
                MySocket ms = mss.accept();
                new Thread(new Service(ms)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

