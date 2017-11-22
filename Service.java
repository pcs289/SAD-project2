import java.lang.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class Service implements Runnable{
	MySocket ms;
    String currentNick;
    Server serv;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public Service(MySocket s, String nick, Server serv) {
        this.ms = s;
        this.currentNick = nick;
        this.serv = serv;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.ms.getInputStream()));
            PrintWriter out = new PrintWriter(this.ms.getOutputStream(), true);

            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }

                Set<String> keySet = this.serv.llista.keySet();
                System.out.println(keySet.toString());
                for (String nick : keySet){
                    if(!nick.equals(currentNick)){
                        PrintWriter outbroadcast = new PrintWriter(this.serv.llista.get(nick).getOutputStream(), true);
                        outbroadcast.println(RED + nick + "-> " + RESET + line);
                    }else {
                        out.println(YELLOW + currentNick + "-> " + RESET + line);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}