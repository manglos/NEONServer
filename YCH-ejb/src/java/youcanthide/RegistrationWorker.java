/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

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

/**
 *
 * @author uman
 */
public class RegistrationWorker implements Runnable {
	//We'll need a ObjectInputStream and FileInputStream here to recieve objects over the socket
    private Socket server;
    private String line,input;
    String un, pw, pn, fn, ln;
    int myClientNumber;
    
    //DataInputStream in = null;// new DataInputStream (server.getInputStream());
    PrintWriter out = null;// new PrintStream(server.getOutputStream());
    BufferedReader b = null;// new BufferedReader(new InputStreamReader(server.getInputStream()));

    
    Socket smtpSocket = null;
    InputStream is=null;
    ObjectInputStream ois=null;
    ObjectOutputStream oos = null;
    OutputStream os = null;
    String hostname = "localhost";

    public RegistrationWorker(Socket server, int n) {
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
                
                //if(line!=null && line.equalsIgnoreCase("system:exit"))
                   //break;
                
                String parems[] = line.split(":", 2);
                Player p=null;

                if(parems[0].equalsIgnoreCase("search")){
                    //System.out.println(parems[1]);
                    p = Database.getPlayerByUsername(parems[1]);
                    
                    if(p!=null)
                        oos.writeObject((String)"create:"+p.getUsername()+" "+p.getPassword()+" "+p.getFirstName()+" "+p.getLastName());
                    else
                        oos.writeObject((String)"nouser:There is no user with username " + parems[1]);
                }
                else if(parems[0].equalsIgnoreCase("create")){
                    //System.out.println("creating player: " + parems[1]);
                    parseLine(parems[1]);
                    if(un!=null && Database.getPlayerByUsername(un)==null){
                        p = new Player(fn, ln, un, pw, true);
                        new Database().addPlayer(p);
                        new LeaderBoard().addPlayer(p);
                        oos.writeObject((String)"create:"+un+" "+pw+" "+fn+" "+ln+" ");
                    }
                    else{
                        oos.writeObject((String)"error:username "+un+" is already in use");
                    }
                }
            

            if(line!=null && line.equalsIgnoreCase("system:exit")){
                //in.close();
                is.close();
                ois.close();
                os.close();
                oos.close();
                server.close();
            }

            //line = b.readLine();
            } 
        } catch (IOException ioe) {
          System.err.println("IOException on socket listen: " + ioe);
          ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
          System.err.println("CNFE : " + cnfe);
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
