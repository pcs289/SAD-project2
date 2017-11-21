import java.lang.*;
import java.io.*;
import java.net.*;

public class Service implements Runnable{
	MySocket ms;
    String nick;

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
                out.println(nick + "-> "+ line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}