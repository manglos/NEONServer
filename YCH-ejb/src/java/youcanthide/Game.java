/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package youcanthide;

import java.util.ArrayList;


public class Game {
    private int id;
    private ArrayList<Player> players; // possibly redundant?
    private ArrayList<Player> lobby;
    private Stats statistics;
    private double time;
    private String location, size;
    private int numIt;
    static int gameNumber=0;
    
    public Game() {
        id = ++gameNumber; 
        players = new ArrayList<Player>();
        statistics = new Stats();
    }
    public Game(String l, String s, int n, int t) {
        id = ++gameNumber; 
        players = new ArrayList<Player>();
        statistics = new Stats();
        location = l;
        size = s;
        numIt = n;
        time = t;
    }
    
    
    // A Player notifies us of a change:
    public void notifyChange(GameEvent e) {
        // Do something with this information?
        //notifyObservers();
    }
    
    // Notify all observers of a change:
    /*private void notifyObservers() {
        for (int i=0; i<this.observers.size(); i++) {
            this.observers.get(i);
        }
    }*/
    
    public void setTimeLimit(Double limit) {
        time = limit;
    }
    
    public double getTimeLimit() {
        return time;
    }
    
    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
        //addObserver(newPlayer);
    }
    
    public ArrayList<Player> getPlayers(){
        return players;
    }
    
    public ArrayList<Player> getLobby(){
        return lobby;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getSize(){
        return size;
    }
    
    public int getId(){
        return id;
    }
    
    public int getNumIt(){
        return numIt;
    }
    
    public void setPlayers(ArrayList<Player> newList){
        players = newList;
    }
    
    public void setLobby(ArrayList<Player> newList){
        lobby = newList;
    }
    
    public void setLocation(String l){
        location = l;
    }
    
    public void setSize(String s){
        size = s;
    }
    
    public void setNumIt(int n){
        numIt = n;
    }
    
    private void addObserver(Player newObserver) {
        lobby.add(newObserver);
    }
}

