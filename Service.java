import java.lang.*;
import java.io.*;
import java.net.*;

public class Service implements Runnable{
	MySocket ms;
    String nick;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";

    public Service(MySocket s, String nick) {
        this.ms = s;
        this.nick = nick;
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
                // out.println("\\e[1;31m"+nick + ">> \\e[0m" + line);
                out.println(RED + nick + "-> " + RESET + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}