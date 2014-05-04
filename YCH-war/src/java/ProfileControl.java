/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Utilities.Utils;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.DatabaseService;



/**
 *
 * @author Christopher Manglos
 */
@WebServlet(name = "ProfileControl", urlPatterns = {"/ProfileControl"})
public class ProfileControl extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/moxie.oswego.edu_40770/DatabaseService/Database.wsdl")
    private DatabaseService service;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        //dispatcher.forward(request, response);
        String me = (String)request.getSession().getAttribute("user");
        String un = (String)request.getParameter("un");
        boolean full=false;
        
        System.out.println("Session User = " + me);
        System.out.println("Request Info For = " + un);
        
        if(request.getParameter("mode")!=null){
            if(request.getParameter("mode").equalsIgnoreCase("full"))
                full=true;
        }
        
        //if user is logged in, boolean is true, and local user is set to master
        if(me!=null && me.equals(un)){
            Utils.setOnline(me);
            request.setAttribute("isuser", new Boolean(true));
            request.setAttribute("user", me);
        }
        else if(me!=null && un!=null && un.equalsIgnoreCase("default")){
            request.setAttribute("isuser", new Boolean(true));
            request.setAttribute("user", me);
        }
        //otherwise, boolean is false, and local user is set to requested one
        else if(!full && me !=null){
            request.setAttribute("user", me);
            request.setAttribute("isuser", new Boolean(false));
        }
        else if(request.getParameter("un").equals("default")){
            dispatcher = request.getRequestDispatcher("needlogin.jsp");
        }
        else if(youcanthide.Database.getPlayerByUsername(un)!=null){
            request.setAttribute("user", un);
            request.setAttribute("isuser", new Boolean(false));
        }
        else if(me==null){
            dispatcher = request.getRequestDispatcher("nouser.jsp?un="+request.getParameter("un"));
        }
        
        
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
