/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Christopher Manglos
 */
public class Database {
    
    static ArrayList<Player> list = new ArrayList<Player>();
    static ArrayList<Game> gameList = new ArrayList<Game>();
    
    public Database(){
        
    }
    
    public static Player getPlayerByUsername(String u){
        
        for(Player p : list){
            if(p.getUsername().equals(u))
                return p;
        }
        
        return null;
        
    }
    
    public static boolean checkPassword(String u, String pw){
        for(Player p : list){
            if(p.getUsername().equals(u))
                if(p.getPassword().equals(pw))
                    return true;
        }
        
        return false;
        
    }
    
    public static Game getGameById(int i){
        
        for(Game g : gameList){
            if(g.getId()==i)
                return g;
        }
        
        return null;
        
    }
    
    public static ArrayList<Game> getGameList(){
        return gameList;
    }
    
    public static boolean addGame(Game g){
        if(gameList.contains(g))
            return false;
        
        gameList.add(g);
        return true;
    }
    
    public static boolean delGame(Game g){
        if(!gameList.contains(g))
            return false;
        
        gameList.remove(g);
        return true;
    }
    
    
    public static boolean addPlayer(Player p){
        if(list.contains(p))
            return false;
        
        list.add(p);
        return true;
    }
    
    public static boolean isSame(String username, Player user){
        if(username==null || user == null)
            return false;
        System.out.println(username.equals(user.getUsername()));
        return username.equals(user.getUsername());
        
    }
    
    public static void sortGamesBy(String s){
        Comparator c=null;
        if(s.equalsIgnoreCase("id")){
            System.out.println("sorting by id");
            c = new CompairById();
        }
        else if(s.equalsIgnoreCase("numit"))
            c = new CompairByNumIt();
        else
            return;
       
        Collections.sort(gameList, c);
    }
    
    public static ArrayList<Player> getList(){
        return list;
    }
    
    public static void setList(ArrayList<Player> l){
        list=l;        
    }  
    
    public static boolean addMeshToPlayer(String un, String pw, Mesh m){
        Player p = getPlayerByUsername(un);
        if(p!=null && p.getPassword().equals(pw)){
            if(p.addMesh(m))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
