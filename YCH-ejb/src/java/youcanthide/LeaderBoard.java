package youcanthide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christopher Manglos
 */
public class LeaderBoard {
    static ArrayList<Player> list = new ArrayList<Player>();
    static int length;
    static int index;
    static int highestXPNum;
    
    public LeaderBoard(){
        index=0;
        length=10;
        highestXPNum=0;
    }
    private static void init() {
        length = 10;
    }
    public static void addPlayer(Player p){
        if (list.isEmpty()) init();
        list.add(p);
    }
    
    
    public static ArrayList<Player> getList(){
        return list;
    }
    
    public static void sortBy(String s){
        Comparator c=null;
        if(s.equals("firstName")){
            c = new CompairByFirstName();
        }
        else if(s.equalsIgnoreCase("lastName")){
            c = new CompairByLastName();
        }
        else if(s.equals("username")){
            c = new CompairByUsername();
        }
        else
            return;
       if (list != null) {
            Collections.sort(list, c);
       }
    }
    
    public static String print(){
        String result="";
        for(Player p : list){
            result+=p.getName() + "\n";
        }
        return result;
    }
    
    public String toString(){
        String result="";
        for(Player p : list){
            result+=p.getName() + "\n";
        }
        return result;
    }
}
