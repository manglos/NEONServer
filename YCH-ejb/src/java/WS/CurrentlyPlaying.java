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
@WebService(serviceName = "CurrentlyPlaying")
@Stateless()
public class CurrentlyPlaying {

    /**
     * This is a sample web service operation
     */
    @WebMethod
    public String print() {
        return youcanthide.CurrentlyPlaying.print();
    }
    @WebMethod
    public ArrayList<String> getCurrentlyList() {
        ArrayList<String> temp = new ArrayList<String>();
        for (Player p : youcanthide.CurrentlyPlaying.getList()) {
            temp.add(p.getUsername());
        }
        return temp;
    }
    @WebMethod
    public void sortBy(String s) {
        youcanthide.CurrentlyPlaying.sortBy(s);
    }
    @WebMethod
    public void addPlayerToCurrent(String uname) {
        youcanthide.CurrentlyPlaying.addPlayer(youcanthide.Database.getPlayerByUsername(uname));
    }
}
