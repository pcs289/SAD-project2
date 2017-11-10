import java.lang.*;
import java.io.*;
import java.net.*;

public class Client{
	
	MySocket ms;
	BufferedReader in, br_ky;
    PrintWriter out;
    
    public Client(int ip, int port){
        try{
            this.ms = new MySocket(ip, port);
            System.out.println("Connexio establerta");
            in = new BufferedReader(new InputStreamReader(this.ms.getInputStream()));
            out = new PrintWriter(this.ms.getOutputStream(),true);
            br_ky = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeToSocket(){
    	// Input Thread
    	String linia;
		while ((linia = br_ky.readLine()) != null){
    		out.println(linia);
		}
    }
	
    public void readFromSocket(){
		// Output Thread
		String linia;
		while ((linia = in.readLine()) != null){
   			System.out.println(linia);
		}
   	}
}	