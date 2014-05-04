/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import youcanthide.*;

/**
 *
 * @author uman
 */
@WebServlet(urlPatterns = {"/EditControl"})
public class EditControl extends HttpServlet {

    String debug;
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
        RequestDispatcher dispatcher;
        debug="";
        String un = (String)request.getSession().getAttribute("user");
        System.out.println("Session user = " + un);
        if(un!=null){
            dispatcher = request.getRequestDispatcher("edit.jsp?debug="+debug);
            dispatcher.forward(request, response);
        }
        else{
            dispatcher = request.getRequestDispatcher("needlogin.jsp");
            dispatcher.forward(request, response);
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
        
        RequestDispatcher dispatcher;
        Database db = new Database();
        Player p = (Player)youcanthide.Database.getPlayerByUsername((String)request.getSession().getAttribute("user"));
        
        String fn, ln, un, pw, pwc;
        int x=0;
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
       
        if(!pw.equals(pwc)){
            debug="Passwords do not match!";
            p=null;
        }
        if(p!=null && !p.getUsername().equals(un) && db.getPlayerByUsername(un)!=null){
            debug="Username "+un+" is already in use, please choose another.";
            p=null;
        }
        
        
        if(p!=null){
            p.editInfo(fn, ln, un, pw);
            request.getSession().setAttribute("user", p.getUsername());
            dispatcher = request.getRequestDispatcher("ProfileControl?un="+p.getUsername()+"&amp;mode=full.jsp");
        }
        else
            dispatcher = request.getRequestDispatcher("edit.jsp?debug="+debug);
        
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
}
