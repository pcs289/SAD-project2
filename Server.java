import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class Server{

    ConcurrentHashMap<String, MySocket> llista;

    public static final String CYAN = "\u001B[36m";    
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

	public Server(int port){
        try {
            this.llista = new ConcurrentHashMap<String, MySocket>();
            MyServerSocket mss = new MyServerSocket(port);
            while (true) {
                MySocket ms = mss.accept();
                String actualNick = this.requestName(ms); 
                this.llista.put(actualNick, ms);             
                System.out.println("Client with nickname: " + actualNick + " connection started");
                new Thread(new Service(ms, actualNick, this)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String requestName(MySocket s){
        PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Boolean check = true;
        String acceptedNick = null;
        Set<String> keys = this.llista.keySet();
        
        do{
            out.println("Quin nickname vols tenir? ");
            try{
                acceptedNick = in.readLine();
            }catch(Exception e){
                e.printStackTrace();
            }
            for(String name : keys){
                if(name.equals(acceptedNick)){
                    out.println("Aquest nick ja esta en us, tria'n un altre!");
                    check = false;
                }else{check = true;}
            }
        }while(!check);  

        for (String nick : keys){
            if(!nick.equals(acceptedNick)){
                PrintWriter outbroadcast = new PrintWriter(this.llista.get(nick).getOutputStream(), true);
                outbroadcast.println(CYAN + "Client with nickname: " + RED + acceptedNick + CYAN + " connection started" + RESET);
            }
        }   
        return acceptedNick;
    }
    
}

