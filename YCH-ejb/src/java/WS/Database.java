/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import youcanthide.*;

/**
 *
 * @author TONY
 */
@WebService
@Stateless()
public class Database {

    /**
     * This is a sample web service operation
     */
    @WebMethod()
    public void addGame(String loc , String size , int a, int b) {
        youcanthide.Database.addGame(new Game(loc, size, a , b));
    }
    @WebMethod
    public void sortBy(String s) {
        youcanthide.Database.sortGamesBy(s);
    }
    /*
    @WebMethod
    public ArrayList<Game> getGamesList() {
        return youcanthide.Database.getGameList();
            }
    @WebMethod
    public Game getGameById(int id) {
        return youcanthide.Database.getGameById(id);
    }
    * */
    @WebMethod(operationName="getPlayerStringByUsername")
    public String getPlayerStringByUsername(String u) {
        Player temp = youcanthide.Database.getPlayerByUsername(u);
        if (temp != null) {
            return "player:"+temp.getInfo();
        } 
        return "error: user doesn't exist";
    }
    
    @WebMethod(operationName="checkPassword")
    public String checkLogin(String u, String pw) {
        Player temp = youcanthide.Database.getPlayerByUsername(u);
        if (temp != null) {
            if(youcanthide.Database.checkPassword(u, pw))
                return "player:"+temp.getInfo();
            else
                return "error: password incorrect";
        } 
        return "error: user doesn't exist";
    }
    
    @WebMethod
    public void addPlayer(String first, String last, String uname, String pass, boolean on ) {
        youcanthide.Database.addPlayer(new Player(first,last,uname,pass,on));
    }
    
    @WebMethod
    public boolean addMeshToPlayer(String username, String password, int width, int height, String address) {
        //youcanthide.Database.getPlayerByUsername(un)
        return youcanthide.Database.addMeshToPlayer(username, password, new youcanthide.Mesh(width, height, address));
    }
    @WebMethod
    public ArrayList<String> getUsernames() {
        ArrayList<String> temp = new ArrayList<String>();
        for (Player p : youcanthide.Database.getList()) {
            temp.add(p.getUsername());
        }
        return temp;
    }
    @WebMethod
    public boolean unameIsAvailable(String un) {
        return (youcanthide.Database.getPlayerByUsername(un) == null);
    }
}
