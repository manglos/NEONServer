package Utilities;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TONY
 */
public class Utils {

    public static void addLogin(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        port.addLogin(arg0);
    }

    public static String getColor(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        return port.getColor(arg0);
    }

    public static String getFirstName(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        return port.getFirstName(arg0);
    }

    public static String getLastName(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        return port.getLastName(arg0);
    }

    public static int getLoginCount(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        return port.getLoginCount(arg0);
    }

    public static String getPassword(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        return port.getPassword(arg0);
    }

    public static java.util.List<java.lang.String> getUsernames() {
        ws.DatabaseService service = new ws.DatabaseService();
        ws.Database port = service.getDatabasePort();
        return port.getUsernames();
    }

    public static void setOffline(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        port.setOffline(arg0);
    }

    public static void setOnline(java.lang.String arg0) {
        ws.GetPlayerInfoService service = new ws.GetPlayerInfoService();
        ws.GetPlayerInfo port = service.getGetPlayerInfoPort();
        port.setOnline(arg0);
    }

}
