/*	There's nothing to change in this file except the PORT
 *	Otherwise, all socket functionality is done via the ClientWorker
 *  Still a good idea to understand what's going on here..
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import youcanthide.*;

/**
 *
 * @author montynewman
 */
@WebServlet(name = "ReceiveData", urlPatterns = {"/ReceiveData"})
public class ReceiveData extends HttpServlet {
    static final int PORT = 4890; //This port needs to match your client port
	
	//I'm not using these, but they're what are needed for sending objects over the socket
    //FileInputStream fis = null;
    //ObjectInputStream ois = null;
	
	
    int clientNumber=0;  
	
	//
    DataInputStream is;
    PrintStream ps;
    Socket clientSocket = null;
    BufferedReader b=null;
    ServerSocket echoServer = null;
    
    /**
     * This is the important bit...
	 * This opens the socket on the port you chose and makes a new ClientWorker
	 * every time a connection is opened
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            echoServer = new ServerSocket(PORT);
            System.out.println("opened socket");
        }
        catch (IOException e) {
           System.out.println(e);
        }
        
        //System.out.println("here");


        while(true){
			//ClientWorker and a new Thread is made every time we open a connection
            ClientWorker w;
            try{
              w = new ClientWorker(echoServer.accept(), clientNumber++);
              Thread t = new Thread(w);
              t.start();
            } catch (IOException e) {
              System.out.println("Accept failed: " + PORT);
              System.exit(-1);
            }
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
