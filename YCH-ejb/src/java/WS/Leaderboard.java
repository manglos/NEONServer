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
import youcanthide.Player;

/**
 *
 * @author TONY
 */
@WebService(serviceName = "Leaderboard")
@Stateless()
public class Leaderboard {

    /**
     * This is a sample web service operation
     */
    @WebMethod
    public void sortBy(String s) {     
        youcanthide.LeaderBoard.sortBy(s);
    }
    @WebMethod
    public String print() {
        return youcanthide.LeaderBoard.print();
    }
    /*
    @WebMethod
    public ArrayList<youcanthide.Player> getList() {
        
        return youcanthide.LeaderBoard.getList();
    }
    */
    @WebMethod
    public ArrayList<String> getUsernames() {
        ArrayList<String> temp = new ArrayList<String>();
        for (Player p : youcanthide.LeaderBoard.getList()) {
            temp.add(p.getUsername());
        }
        return temp;
    }
    @WebMethod
    public void addPlayerToLeader(String uname) {
        youcanthide.LeaderBoard.addPlayer(youcanthide.Database.getPlayerByUsername(uname));
    }
    
}
