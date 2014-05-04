/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.CurrentlyPlaying_Service;
import ws.DatabaseService;
import ws.Leaderboard_Service;
import Utilities.Utils;


/**
 *
 * @author Christopher Manglos
 */
@WebServlet(name = "NewPlayer", urlPatterns = {"/NewPlayer"})
public class NewPlayer extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/moxie.oswego.edu_40770/Leaderboard/Leaderboard.wsdl")
    private Leaderboard_Service service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/moxie.oswego.edu_40770/DatabaseService/Database.wsdl")
    private ws.DatabaseService service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/moxie.oswego.edu_40770/CurrentlyPlaying/CurrentlyPlaying.wsdl")
    private CurrentlyPlaying_Service service;
    
    String title="New Player Sign-in";
    String debug="";
    //LeaderBoard currentLeaderBoard = new LeaderBoard();
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse 
            response) throws ServletException, IOException {
        
        debug="";
        RequestDispatcher dispatcher = request.getRequestDispatcher("newplayer.jsp?debug="+debug);
        dispatcher.forward(request, response);
        
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
        RequestDispatcher dispatcher;
        
        String fn, ln, un, pw, pwc;
        boolean on = false;
        boolean inGame=false;
        fn=null;
        ln=null;
        un=null;
        pw=null;
        pwc=null;
        debug="";
        
        if(request.getParameter("firstName")!=null){
            fn=request.getParameter("firstName");
        }
        if(request.getParameter("lastName")!=null){
            ln=request.getParameter("lastName");
        }
        if(request.getParameter("userName")!=null){
            un=request.getParameter("userName");
        }
        if(request.getParameter("password")!=null){
            pw=request.getParameter("password");
        }
        if(request.getParameter("password-confirm")!=null){
            pwc=request.getParameter("password-confirm");
        }   
        if(request.getParameter("ingame")!=null){
            if(!request.getParameter("ingame").equals("0")){
                inGame=true;
            }
            else{
                inGame=false;
            }
        }
        String me = un;
        System.out.println("New Player me = " + me);
        /*
        if(inGame){
            addPlayer_1(un);
            sortBy("xp");
        }
        */
        if(!pw.equals(pwc)){
            debug="Passwords do not match!";
            me=null;
        }
        if(!unameIsAvailable(me)){
            debug="Username "+un+" is already in use, please choose another.";
            me=null;
        }
        
        if(me!=null){
            youcanthide.Player p = new youcanthide.Player(fn, ln, un, pw, on);
            youcanthide.Database.addPlayer(p);
            if ( on)
            addPlayerToCurrent(me);
            addPlayerToLeader(me);
            sortBy("username");
            System.out.print("AAAAAAAAA" + me);
            request.getSession().setAttribute("user", me);
            dispatcher = request.getRequestDispatcher("ProfileControl?un="+me+"&amp;mode=full");
        }
        else {
            dispatcher = request.getRequestDispatcher("newplayer.jsp?debug="+debug);
        }
        dispatcher.forward(request, response);
        
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

    

    private void sortBy(java.lang.String arg0) {
        ws.CurrentlyPlaying port = service.getCurrentlyPlayingPort();
        port.sortBy(arg0);
    }

    private void addPlayer(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, boolean arg4) {
        ws.Database port = service_1.getDatabasePort();
        port.addPlayer(arg0, arg1, arg2, arg3, arg4);
    }
    

    private boolean unameIsAvailable(java.lang.String arg0) {
        ws.Database port = service_1.getDatabasePort();
        return port.unameIsAvailable(arg0);
    }

    private void addPlayerToCurrent(java.lang.String arg0) {
        ws.CurrentlyPlaying port = service.getCurrentlyPlayingPort();
        port.addPlayerToCurrent(arg0);
    }

    private void addPlayerToLeader(java.lang.String arg0) {
        ws.Leaderboard port = service_2.getLeaderboardPort();
        port.addPlayerToLeader(arg0);
    }

}
