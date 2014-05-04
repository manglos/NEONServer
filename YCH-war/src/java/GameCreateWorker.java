/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import youcanthide.*;

/**
 *
 * @author uman
 */
public class GameCreateWorker implements Runnable {
	//We'll need a ObjectInputStream and FileInputStream here to recieve objects over the socket
    private Socket server;
    private String line,input;
    String lo, si;
    int id, nI, gL;
    int myClientNumber;
    Game g;
    
    //DataInputStream in = null;// new DataInputStream (server.getInputStream());
    PrintWriter out = null;// new PrintStream(server.getOutputStream());
    BufferedReader b = null;// new BufferedReader(new InputStreamReader(server.getInputStream()));

    
    Socket smtpSocket = null;
    InputStream is=null;
    ObjectInputStream ois=null;
    ObjectOutputStream oos = null;
    OutputStream os = null;
    String hostname = "localhost";

    public GameCreateWorker(Socket server, int n) {
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
          
            is = server.getInputStream();
            ois = new ObjectInputStream(is);
            os = server.getOutputStream();
            oos = new ObjectOutputStream(os);

            while (true) {
                
                line = (String)ois.readObject();
                System.out.println(line);
                
                String parems[] = line.split(":", 2);
                
                if(parems[0].equalsIgnoreCase("newgame")){
                    parseLine(parems[1]);
                    g = new Game(lo, si, nI, gL);
                    Database.addGame(g);
                    oos.writeObject((String)"newgame:"+id+" "+lo+" "+si+" "+nI+" "+gL);
                }
                else
                    oos.writeObject((String)"error:what did you type in?");

                if(line!=null && line.equalsIgnoreCase("system:exit")){
                    is.close();
                    ois.close();
                    os.close();
                    oos.close();
                    server.close();
                }
            } 
        } catch (IOException ioe) {
          System.err.println("IOException on socket listen: " + ioe);
          ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
          System.err.println("CNFE : " + cnfe);
        }
    }
    
    void parseLine(String s){
        String parems[] = s.split(" ", 4);
        
        //id = Integer.parseInt(parems[0]);
        lo = parems[0];
        si = parems[1];
        nI = Integer.parseInt(parems[2]);
        gL = Integer.parseInt(parems[3]);
        
    }
}

