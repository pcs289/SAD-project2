import java.lang.*;
import java.io.*;
import java.net.*;

public class Service implements Runnable{
	MySocket ms;
    ConcurrentHashMap llista<String, MySocket>;

    public Service(MySocket s, ConcurrentHashMap llista) {
        this.ms = s;
        this.llista = llista;
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
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}