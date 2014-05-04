/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author uman
 */
public class ClientWorker implements Runnable {
	//We'll need a ObjectInputStream and FileInputStream here to recieve objects over the socket
    private Socket server;
    private String line,input;
    String un, pw, pn, fn, ln;
    int myClientNumber;
    
    //DataInputStream in = null;// new DataInputStream (server.getInputStream());
    PrintWriter out = null;// new PrintStream(server.getOutputStream());
    BufferedReader b = null;// new BufferedReader(new InputStreamReader(server.getInputStream()));

    
    Socket smtpSocket = null;  
    DataOutputStream dos = null;
    DataInputStream dis = null;
    String hostname = "localhost";

    public ClientWorker(Socket server, int n) {
      this.server=server;
      myClientNumber=n;
    }

	/* This is the server side functionality
	 * Most changing needs to happen here
	 */
    @Override
    public void run () {

        input="";

        try {
          
            out = new PrintWriter(server.getOutputStream(), true);
            b = new BufferedReader(new InputStreamReader(server.getInputStream()));

            out.println("****************************************************");
            out.println("*     Welcome to the You Can't Hide Server!!       *");
            out.println("*    This is where you can create new players      *");
            out.println("****************************************************");
            out.println("         You are client number: " + myClientNumber);

            while (true) {
                
                line = b.readLine();
                System.out.println(line);
                
                if(line!=null && line.equalsIgnoreCase("system:exit"))
                    break;
                
                String parems[] = line.split(":", 2);
                Player p=null;

                if(parems[0].equalsIgnoreCase("search")){
                    p = Database.getPlayerByUsername(parems[1]);
                    if(p!=null){
                        out.println("exists");
                    }
                }
                else if(parems[0].equalsIgnoreCase("create")){
                    parseLine(parems[1]);
                    p = new Player(fn, ln, un, pw, true);
                    new Database().addPlayer(p);
                    new LeaderBoard().addPlayer(p);
                    if(p!=null){
                        out.println("created");
                    }   
                }
                
                if(p==null){
                    out.println("available");
                }
            }

            if(line!=null && line.equalsIgnoreCase("system:exit")){
                //in.close();
                out.close();
                b.close();
                server.close();
            }

            line = b.readLine();
            
        } catch (IOException ioe) {
          System.err.println("IOException on socket listen: " + ioe);
          ioe.printStackTrace();
        }
    }
    
    void parseLine(String s){
        String parems[] = s.split(" ", 5);
        
        un = parems[0];
        pw = parems[1];
        fn = parems[2];
        ln = parems[3];
        pn = parems[4];
        
    }
}
