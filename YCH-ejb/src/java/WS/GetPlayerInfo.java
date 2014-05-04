/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author TONY
 */
@WebService
@Stateless()
public class GetPlayerInfo {

    /**
     * This is a sample web service operation
     */
    @WebMethod
    public String getFirstName(String uname) {
        return youcanthide.Database.getPlayerByUsername(uname).getFirstName();
    }
    @WebMethod
    public String getLastName(String uname) {
        return youcanthide.Database.getPlayerByUsername(uname).getLastName();
    }
    @WebMethod
    public String getColor(String uname) {
        return youcanthide.Database.getPlayerByUsername(uname).getColor();
    }
    @WebMethod
    public String getPassword(String uname) {
        return youcanthide.Database.getPlayerByUsername(uname).getPassword();
    }
    @WebMethod
    public int getLoginCount(String uname) {
        return youcanthide.Database.getPlayerByUsername(uname).getLoginCount();
    }
    @WebMethod
    public void addLogin(String uname) {
        youcanthide.Database.getPlayerByUsername(uname).addLogin();
    }
    @WebMethod
    public void setOnline(String uname) {
        youcanthide.Database.getPlayerByUsername(uname).setOnline(true);
    }
    @WebMethod
    public void setOffline(String uname) {
        youcanthide.Database.getPlayerByUsername(uname).setOnline(false);
    }
}
