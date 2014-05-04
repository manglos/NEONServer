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
public class CurrentlyPlaying {
    static ArrayList<Player> list = new ArrayList<Player>();
    static int length;
    static int index;
    //int highestXPNum;
    
    public CurrentlyPlaying(int l){
        index=0;
        length=l;
        //highestXPNum=0;
    }
    private static void init() {
        length = 10;
    }
    public static void addPlayer(Player p){
        if (list.isEmpty()) init();
        if(list.size()<length){
            list.add(p);
            System.out.println("Successfully added " + p);
            return;
        }
    }
    
    public void removePlayer(Player p){
        if(list.contains(p)){
            list.remove(p);
        }
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
       
        Collections.sort(list, c);
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

