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
import javax.xml.ws.WebServiceRef;
import ws.DatabaseService;
import ws.GetPlayerInfoService;

/**
 *
 * @author uman
 */
@WebServlet(urlPatterns = {"/GameControl"})
public class GameControl extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/GetPlayerInfoService/GetPlayerInfo.wsdl")
    private GetPlayerInfoService service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/DatabaseService/Database.wsdl")
    private ws.DatabaseService service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/DatabaseService/Database.wsdl")
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
        /*
        if(getGamesList().isEmpty()){
            addGame("here", "large", 5, 5);
            addGame("there", "small", 1, 10);
        }
        */
        String sortString=request.getParameter("sortby");
        System.out.println(sortString);
        
        
        if(sortString!=null) {
            sortBy(sortString);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("gameslist.jsp");
        
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

    private void addGame(java.lang.String arg0, java.lang.String arg1, int arg2, int arg3) {
        ws.Database port = service_1.getDatabasePort();
        port.addGame(arg0, arg1, arg2, arg3);
    }
    /*
    private java.util.List<ws.Game> getGamesList() {
        ws.Database port = service_1.getDatabasePort();
        return port.getGamesList();
    }
    */
    private void sortBy(java.lang.String arg0) {
        ws.Database port = service_1.getDatabasePort();
        port.sortBy(arg0);
    }
    
}
